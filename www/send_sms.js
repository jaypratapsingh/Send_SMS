var send_sms = {
    send_message: function(successCallback, errorCallback, ph_no, message) {
		cordova.exec( successCallback,
		            errorCallback,
					"Send_SMS",
					"SMS",
					[{"phone_number":ph_no,"message_text":message}]
					);
    }
}

module.exports = send_sms;

