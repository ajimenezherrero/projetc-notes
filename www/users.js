(function() {
  var app = angular.module('users', []);

  
  app directive('userPanel', function(){
    restrict = 'E',
    templateUrl: 'users.html',
    controller:function($http){
		var projectNotes = this;
		projectNotes.users = [];
		
		$http.get('http://localhost:8080/notas-api/user').success(function(data){
			projectNotes.users = data;
		});
	},
    controllerAs: 'user_panel'
  });

})();