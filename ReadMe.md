# *********Cordova : Send SMS From App************** 

By using this plugin you can send sms to single and multiple number with one click


## Install this plugin using:

cordova plugin add com.jp.plugin.send_sms



## Remove Plugins :

cordova plugin remove com.jp.plugin.send_sms



## Put the below code in your javascript code to get the ip address: 

send_sms.send_message(
	function(success)
	{
            console.log(success);
        }, 
	function(error)
	{
            console.log(error);
        },
	ph_no, message
    );




** ph_no :- String Format (For Ex. "91xxxxxxxx, 70xxxxxxxx") **
** message :- String Format **




> GitHub URL:   https://github.com/jaypratapsingh/send_sms

> npm url :     https://www.npmjs.com/package/com.jp.plugin.send_sms
