var exec = require('cordova/exec');

// helper functions
var callNative = function (successCallback, errorCallback, name) {
  exec(handleUndefined(successCallback), handleUndefined(errorCallback), 'Insomnia', name, []);
};

var handleUndefined = function (callback) {
  return callback || defaultHandler;
};

var defaultHandler = function (msg) {};


// interface object
var Insomnia = function () {};

Insomnia.prototype.keepAwake = function (successCallback, errorCallback) {
  callNative(successCallback, errorCallback, 'keepAwake');
};

Insomnia.prototype.allowSleepAgain = function (successCallback, errorCallback) {
  callNative(successCallback, errorCallback, 'allowSleepAgain');
};

module.exports = new Insomnia();