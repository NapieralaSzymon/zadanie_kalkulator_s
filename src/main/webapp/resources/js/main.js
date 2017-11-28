var calculatorApp = angular.module("calculatorApp", []);

calculatorApp.controller("CalculatorController", ["$http", "$scope",
		function CalculatorController($http, $scope) {

	$scope.countryIndex = null;
	$scope.currencyIndex = null;
	$scope.dailyIncome = 0;

	$scope.countries = [];
	$http.get("api/countries").then(function(response) {
		$scope.countries = response.data;
	});

	$scope.gain = 0;

	$scope.getCurrentCountry = function() {
		return ($scope.countryIndex != null)
				? $scope.countries[parseInt($scope.countryIndex)] : null;
	};

	$scope.getCurrentCountrySymbol = function() {
		var country = $scope.getCurrentCountry();
		return (country != null) ? country.countrySymbol : null;
	};

	$scope.getCurrentCountryCurrencySymbol = function() {
		var country = $scope.getCurrentCountry();
		return (country != null) ? country.currencySymbol : null;
	};

	$scope.getCurrentCurrency = function() {
		return ($scope.currencyIndex != null)
				? $scope.countries[parseInt($scope.currencyIndex)] : null;
	};

	$scope.getCurrentCurrencySymbol = function() {
		var currency = $scope.getCurrentCurrency();
		return (currency != null) ? currency.currencySymbol : null;
	};

	$scope.calculateGain = function() {
		$http.get("api/gain", {
			params: {
				countryCode: $scope.getCurrentCountrySymbol(),
				dailyIncome: $scope.dailyIncome,
				targetCurrency: $scope.getCurrentCurrencySymbol()
			}
		}).then(function(response) {
			$scope.gain = response.data;
		});
	};

}]);
