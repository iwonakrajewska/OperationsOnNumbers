export class LoginRequest {
  userName: string;
  password: string;

   constructor(  _username: string, _password: string  ) {
    this.userName = _username;
    this.password = _password;
   }
}
