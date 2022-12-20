import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Locataire } from '../models/locataire';

@Injectable({
  providedIn: 'root'
})
export class LocataireService {

  private Url = environment.apiLocataire;


  constructor(private fb: FormBuilder ,private httpClient: HttpClient) { }


  public createLocataire(locataire: Locataire): Observable<Locataire>{
    return this.httpClient.post<Locataire>(`${this.Url}`, locataire)
  }
}
