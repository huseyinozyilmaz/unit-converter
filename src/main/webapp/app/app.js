angular.module('unitConverterApp', [])

    .service('lengthConversionService', function($q, $http) {
        this.convertToInch = function (centimetre) {
            var deferred = $q.defer();
            $http.get("/api/centimetre/" + centimetre)
                .then(function (response) {
                    deferred.resolve(response.data.to)
                });
            return deferred.promise;
        }

        this.convertToCentimetre = function (inch) {
            var deferred = $q.defer();
            $http.get("/api/inch/" + inch)
                .then(function (response) {
                    deferred.resolve(response.data.to)
                });
            return deferred.promise;
        }
    })
    .controller('lengthConversionController', function($scope, lengthConversionService) {

        var lengthConversion = this;
        $scope.calculating = false;

        lengthConversion.convert = function() {
            $scope.calculating = true;
            if ($scope.centimetre) {
                lengthConversionService.convertToInch($scope.centimetre)
                    .then(function (result) {
                        $scope.inch = result;
                        $scope.calculating = false;
                    })
            }
            if ($scope.inch) {
                lengthConversionService.convertToCentimetre($scope.inch)
                    .then(function (result) {
                        $scope.centimetre = result;
                        $scope.calculating = false;
                    })
            }
        }
    });
