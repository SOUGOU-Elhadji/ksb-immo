import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { FooterComponent } from './footer/footer.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListApporteurComponent } from './apporteur/list-apporteur/list-apporteur.component';

const routes: Routes = [
  // {path: 'home', component: HomeComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  // {path: '**', redirectTo: 'home', pathMatch: 'full'},
  {
    path: '',
    component: AdminLayoutComponent,
    children: [
      {path: 'home', component: HomeComponent},
      {path: 'apporteurs', component: ListApporteurComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
