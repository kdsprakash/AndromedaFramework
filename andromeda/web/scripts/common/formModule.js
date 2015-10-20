var formModule = angular.module('formModule', [])
.controller('FormController', [ '$http', '$scope', function($http, $scope) 
{
	var self = this;

	$scope.login = function(user) 
	{
        $http.post('/andromeda/security/login', user)
        .then(function(response) 
        {
			$scope.data = response.data;
			if($scope.data.successful) 
			{
				Andromeda.setSessionValue("username", $scope.data.responseObject.username);
				Andromeda.setSessionValue("context", $scope.data.responseObject.context);
				Andromeda.showHomePage();	
			} 
			else 
			{
				Andromeda.showError($scope.data.errorMessage);
			}
		}, 
		function(errResponse) 
		{
			console.error('Error while fetching notes');
		});
    };
} ]);
