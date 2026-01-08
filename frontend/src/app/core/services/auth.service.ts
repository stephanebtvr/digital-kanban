import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private http = inject(HttpClient);

  //Signaux pour l'état du user
  public currentUser = signal<{ username: string; email: string } | null>(null);
  public token = signal<string | null>(localStorage.getItem('auth_token'));

  public login(credentials: any) {
    return this.http.post<any>('/api/auth/login', credentials).pipe(
      tap((res) => {
        localStorage.setItem('auth_token', res.token);
        this.token.set(res.token);
        this.currentUser.set({ username: res.username, email: res.email });
      })
    );
  }

  public logout() {
    localStorage.removeItem('auth_token');
    this.token.set(null);
    this.currentUser.set(null);
  }
}
