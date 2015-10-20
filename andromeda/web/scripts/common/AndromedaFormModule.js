var AndromedaFormModule = angular.module('AndromedaFormModule', [])
.controller('AndromedaFormController', [ '$http', '$scope', function($http, $scope) 
{
	var self = this;

	$scope.login = function(user) 
	{
        $http.post('security/login', user)
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
