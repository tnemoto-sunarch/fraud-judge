$(function(){
//	console.log('hello');
	// =================================
	// formの特定
	// ID指定(変更可能)
	// =================================
	var form = $('#fj_frm');

	if(form){
		// =================================
		// 項目の特定
		// name指定(変更可能)
		// =================================
		var card_no = form.find('input[name=card_no]');
		var exp_date = form.find('input[name=exp_date]');
		var sec_code = form.find('input[name=sec_code]');

		var orgEvents = [];
		//JQueryイベントの検知
		var events = $._data(form.get(0), 'events');
		if(events){
//			console.log('jquery event exists.');
			var originalHandler = events.submit;
//			console.log(originalHandler);
			$.each(originalHandler, function(i, obj){
				orgEvents.push(obj.handler);
			});
			$.each(originalHandler, function(i, obj){
				if(obj){
					form.off('submit', obj.handler);
				}
			});
		}
		//通常のHTMLイベントの検知
		var originalEvent = form.get(0).onsubmit;
		if(originalEvent){
//			console.log('html event exists.');
			form.get(0).onsubmit = ''
			orgEvents.push(originalEvent);
		}
		//submitイベントの書き換え
		form.one('submit', function(event) {
//			console.log('fj_onsubmit start');
			var data = {
				'user_id': 'uid-xxxxx',
				'request_id': 'rid-xxxxx',
				'card_info': {
					'card_no': card_no.val(),
					'exp_date': exp_date.val(),
					'sec_code': sec_code.val()
				}
			}
//			console.log(data);
			// =================================
			// 不正判定ロジック(別ドメイン)の呼出し
			// =================================
			$.ajax({
				url: 'http://localhost:8080/fj/api/v1/sample',
				type: 'POST',
				contentType: 'application/json',
				dataType: "json",
				data: JSON.stringify(data)
			})
			.done((data) => {
				// =================================
				// 成功した場合は、hiddenの埋め込み
				// =================================
//				console.log('success');
//				console.log(data);
				$('<input>"').attr({
					type : 'hidden',
					name : 'token',
					value : data.token
				}).appendTo(form);
			})
			.fail((data) => {
				// =================================
				// 失敗時は何もしない(仕様次第)
				// =================================
//				console.log('error');
//				console.log(data);
			})
			.always((data) => {
				// =================================
				// 成功・失敗に関わらず、イベントを復元し
				// 再度、submitイベントをコール
				// =================================
//				console.log('always');
				if(orgEvents){
					$.each(orgEvents, function(i, handler){
						if(handler){
							form.on('submit', handler);
						}
					})
				}
				form.submit();
			})
			// =================================
			// submitイベントなので、イベントキャンセル
			// =================================
			if(event.preventDefault) {
				event.preventDefault();
			} else {
				// IE対応
				event.returnValue = false;
			}
//			console.log('fj_onsubmit end');
			return false;
		});
	}
})
