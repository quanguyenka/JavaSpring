

var app = angular.module('myApp', []);

app.controller("myController", function($scope) {
	var otos = [
		{maxe: "X1", hangxe: "HUYNDAI", loaixe: "ModernCar", giaxe: 2000000000, namSX: 2007, goiBH: "A",soluong: 3},
		{maxe: "X2", hangxe: "HUYNDAI", loaixe: "MediumCar", giaxe: 1500000000, namSX: 1997, goiBH: "B",soluong: 2},
		{maxe: "X3", hangxe: "BMW", loaixe: "ModernCar", giaxe: 2500000000, namSX: 2006, goiBH: "A1",soluong: 3},
		{maxe: "X4", hangxe: "TOYOTA", loaixe: "OldCar", giaxe: 1000000000, namSX: 1993, goiBH: "C1",soluong: 1},
	];

	$scope.otos = otos;

	$scope.addRow = function() {
		var data = {};
		data.maxe = $scope.maxe;
		data.hangxe = $scope.hangxe;
		data.loaixe = $scope.loaixe;
		data.giaxe = $scope.giaxe;
		data.namSX = $scope.namsx;
		data.goiBH = $scope.goibh;
		data.soluong = $scope.soluong;

		$scope.otos.push(data);
	}

	$scope.removeRow = function(maxe){				
		var index = -1;		
		var comArr = eval( $scope.otos );
		for( var i = 0; i < comArr.length; i++ ) {
			if( comArr[i].maxe === maxe ) {
				index = i;
				break;
			}
		}
		if( index === -1 ) {
			console.log('err');
		}
		$scope.otos.splice( index, 1 );		
	};
});

