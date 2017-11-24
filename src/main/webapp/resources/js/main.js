var calculatorApp = angular.module("calculatorApp", []);

calculatorApp.controller("CalculatorController", ["$http", "$scope",
		function CalculatorController($http, $scope) {

	$scope.countryCode = null;
	$scope.dailyIncome = 0;

	$scope.countryCodes = [];
	$http.get("countries/symbols").then(function(response) {
		$scope.countryCodes = response.data;
	});

	$scope.gain = 0;
	
	$scope.calculateGain = function() {
		$http.get("countries/gain", {
			params: {
				countryCode: $scope.countryCode,
				dailyIncome: $scope.dailyIncome
			}
		}).then(function(response) {
			$scope.gain = response.data;
		});
	};

}]);
