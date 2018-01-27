angular.module('sample').controller('SampleController', SampleController);

SampleController.$inject = ['$scope', '$http'];

function SampleController($scope, $http) {
    $scope.newUser = {};
    $scope.users = [];
    $scope.registrationError = '';
    $scope.statusOk = false;
    $scope.loadUsers = loadUsers;
    $scope.register = register;


    function loadUsers() {
        $http.get('/api/users').then(function(userResponse) {
            $scope.users = userResponse.data;
            console.log($scope.users);
        }, function(error) {
            console.log(error);
        });
    }

    function register() {
        $http.post('/api/users/register', $scope.newUser).then(function(data){
            resetRegisterState();
            setStatusOk();
        }, function(error) {
            console.log(error);
            $scope.statusOk = false;
            $scope.registrationError = error.data.message;
        });
    }

    function resetRegisterState() {
        $scope.newUser = {};
        $scope.registrationError = '';
    }

    function setStatusOk() {
        $scope.statusOk = true;
    }
}