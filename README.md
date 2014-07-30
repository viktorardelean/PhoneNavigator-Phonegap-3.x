PhoneNavigator-Phonegap-3.x
===========================

Phonegap native navigation for Phonegap 3.x

##How to integrate it in your Phonegap 3.x project:

Open a console window
* Go to your Phonegap app root
* Then execute: phonegap local plugin add https://github.com/viktor0710/PhoneNavigator-Phonegap-3.x.git
* Copy "phonenavigator.js" from the repo (www/phonenavigator.js) in your app (ex: yourapp/www)
* Include "phonenavigator.js" in you app
* Copy "cordova.js" from the repo (www/cordova.js) in your app (ex: yourapp/www)
* Include "cordova.js" in you app

##How to use it:

```javascript
//function declaration
function navigateTo (lat, lon, successFn, errorFn) {
    cordova.require('cordova/plugin/phonenavigator').doNavigate(lat, lon, successFn, errorFn);
}

//set lat and lon variables. Most probably read them from the UI
var latitude =  48.137607;
var longitude = 11.568569;

//call function
navigateTo(
    latitude,
    longitude,
    function(){
        console.log("Successfully opened navigator");
    },
    function(){
        console.log("Error opening navigator");
    }
);
```
