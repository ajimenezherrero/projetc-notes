
var app = angular.module('projectNotes',[]);

app.controller('userController', ['$http', function ($http){
	var projectNotes = this;
	projectNotes.users = [];
	
	$http.get('http://localhost:8080/notas-api/user').success(function (data) {
		projectNotes.users = data;
    });	
}]);

app.controller('TabController', function(){
    this.tab = 1;
    
    this.setTab = function(setTab){
        this.tab = setTab;
    };
    this.isSet = function(isSet){
        return this.tab === isSet;
    };
});
