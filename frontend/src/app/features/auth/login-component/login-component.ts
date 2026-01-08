import { Component, inject } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../../core/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule, FormsModule],
  template: `
    <div class="flex justify-center items-center h-screen bg-slate-50">
      <mat-card class="w-[400px] p-8 shadow-xl">
        <mat-card-header class="mb-4">
          <mat-card-title class="text-2xl font-bold text-indigo-600"
            >Connexion Kanban</mat-card-title
          >
        </mat-card-header>
        <form (submit)="onSubmit()">
          <mat-form-field class="w-full mb-4" appearance="outline">
            <mat-label>Nom d'utilisateur</mat-label>
            <input matInput [(ngModel)]="username" name="username" required />
          </mat-form-field>

          <mat-form-field class="w-full mb-6" appearance="outline">
            <mat-label>Mot de passe</mat-label>
            <input matInput type="password" [(ngModel)]="password" name="password" required />
          </mat-form-field>

          <button mat-raised-button color="primary" class="w-full py-6 text-lg" type="submit">
            Se connecter
          </button>
        </form>
      </mat-card>
    </div>
  `,
})
export class LoginComponent {
  private authService = inject(AuthService);
  private router = inject(Router);

  username: string = '';
  password: string = '';

  onSubmit() {
    const credentials = {
      username: this.username,
      password: this.password,
    };

    this.authService.login(credentials).subscribe({
      next: () => {
        this.router.navigate(['/board']);
      },
      error: (err: any) => {
        console.error('Login failed', err);
        alert('Échec de la connexion. Veuillez vérifier vos identifiants.');
      },
    });
  }
}
