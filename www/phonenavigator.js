cordova.define("cordova/plugin/phonenavigator", function(require, exports, module) {
    var exec = require('cordova/exec');
    
    var PhoneNavigator = function() {};
    
   /**
     * Opens phone navigator app to navigate to given lat/lon destination
     *
     * @param {Float} lat - destintation latitude as decimal number
     * @param {Float} lon - destintation longitude as decimal number 
     * @param {Function} successCallback - The callback which will be called when diagnostic of location is successful.
     * * @param {Function} errorCallback - The callback which will be called when diagnostic of location encounters an error.
     * This callback function have a string param with the error.     
     */
    PhoneNavigator.prototype.doNavigate = function(lat, lon, successCallback, errorCallback) {
        return cordova.exec(successCallback,
                            errorCallback,
                            'PhoneNavigator',
                            'doNavigate',
                            [lat, lon]);
    };
        
    var phonenavigator = new PhoneNavigator();
    module.exports = phonenavigator;
});

