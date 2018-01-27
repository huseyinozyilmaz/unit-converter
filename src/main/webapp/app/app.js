angular.module('unitConverterApp', [])

    .service('lengthConversionService', function($q, $http) {
        this.convertToInch = function (centimetre) {
            var deferred = $q.defer();
            $http.get("/centimetre/" + centimetre)
                .then(function (response) {
                    deferred.resolve(response.data.to)
                });
            return deferred.promise;
        }

        this.convertToCentimetre = function (inch) {
            var deferred = $q.defer();
            $http.get("/inch/" + inch)
                .then(function (response) {
                    deferred.resolve(response.data.to)
                });
            return deferred.promise;
        }
    })
    .controller('lengthConversionController', function($scope, lengthConversionService) {

        var lengthConversion = this;

        lengthConversion.convert = function() {
            if ($scope.centimetre) {
                lengthConversionService.convertToInch($scope.centimetre)
                    .then(function (result) {
                        $scope.inch = result;
                    })
            }
            if ($scope.inch) {
                lengthConversionService.convertToCentimetre($scope.inch)
                    .then(function (result) {
                        $scope.centimetre = result;
                    })
            }
        }
    });
