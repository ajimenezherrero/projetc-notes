
var app = angular.module('projectNotes',[]);

app.controller('userController', ['$http', function ($http){
	var projectNotes = this;
	var user = {};
	projectNotes.users = [];
	
	$http.get('http://localhost:8080/notas-api/user').success(function (data) {
		projectNotes.users = data;
    }).
	  error(function(data) {
		  window.alert("ERROR");
	});	
	
	this.addUser = function pushData(){
		projectNotes.users.push(this.user);
		$http({
            method: 'POST',
            url: "http://localhost:8080/notas-api/user",
            data: this.user,
            headers: {'Content-Type': 'application/vnd.note.api.user+json'}
        }).success(function(data) {
		}).error(function(data) {
			window.alert("ERROR");
		});
		this.user = {};
	};
	
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
