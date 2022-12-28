import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Agence } from '../models/agence';


import {catchError, map} from 'rxjs/operators';
import { AgenceDto } from '../dts/agence-dto';

@Injectable({
  providedIn: 'root'
})
export class AgenceService {

  private Url = environment.apiAgence;

  constructor(private httpClient: HttpClient) { }

  // Add Test
  public createTheAgence(agence: AgenceDto): Observable<AgenceDto> {
    return this.httpClient.post<AgenceDto>(`${this.Url}`, agence).pipe(
      catchError(this.handleHttpError)
    )
  }

  // update Test
  public updateTheAgence(agenceDto: AgenceDto): Observable<AgenceDto> {
    const url = `${this.Url}/${agenceDto.id}`;

    return this.httpClient.put<AgenceDto>(url, agenceDto).pipe(
      catchError(this.handleHttpError)
    );
  }

  // METHOD TO CREATE A NEW AGENCE
  public createAgence(agence: AgenceDto): Observable<Object>{
    const headers = { 'content-type': 'application/json'}  

    const params = new HttpParams()
      .set('para1', "value1")
      .set('para2',"value2");

    const body=JSON.stringify(agence);
    console.log(body)
    return this.httpClient.post(this.Url, body, {'headers':headers, observe:'response', 
      reportProgress: true, 'params': params})
      .pipe(
        catchError((err) => {
          console.error(err);
          throw err;
        })
      );
  }

  public addAg(ag: Agence): Observable<Object>{
    return this.httpClient.post(`${this.Url}`, ag);
  }

  // METHOD TO GET ALL AGENCES
  // public getAllAgences(): Observable<Agence[]> {
  //   const params = new HttpParams()
  //     .set('sort',"description")
  //     .set('page',"2");
  //   const headers = new HttpHeaders()
  //     .set('Content-Type', 'application/json');
  //   return this.httpClient.get<Agence[]>(this.Url, {"params": params, 'headers': headers})
  //   // return this.httpClient.get<Agence[]>(`${this.Url}`, {'params': params})
  //   .pipe(
  //     map((response) => {
  //       return response;
  //     }),
  //     catchError((err, caught) => {
  //       console.log('error caught in service', err)
  //         console.error(err);
  //         // return throwError(err);   
  //         throw err;
  //     })
  //   );
  // }

  public getAllAgences(): Observable<Agence[]> {
    return this.httpClient.get<Agence[]>(`${this.Url}`);
  }








  // METHOD TO GET A AGENCE BY ID
  public getAgenceById(id: string): Observable<AgenceDto>{
    const params = new HttpParams()
      .set('sort',"description")
      .set('page',"2");
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');
    return this.httpClient.get<AgenceDto>(`${this.Url}/${id}`, {"params": params, 'headers': headers})
    .pipe(
      map((response) => {
        return response;
      }),
      catchError((error) => {
        console.log('Error caught in service by getting id')
        console.error(error);
        throw error;
      })
    );
  }

  // METHOD TO DELETE A AGENCE
  public deleteAgence(id: string): Observable<Agence>{
    const params = new HttpParams()
      .set('sort',"description")
      .set('page',"2");
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');
    return this.httpClient.delete<Agence>(`${this.Url}/${id}`, {"params": params, 'headers': headers})
      .pipe(
        map((response) => {
          return response;
        }),
        catchError((error) => {
          console.log('Error caught in service by deleting an object');
          console.error(error);
          throw error;
        })
      );
  }

  // METHOD TO UPDATE A AGENCE
  public updateAgence(agence: AgenceDto): Observable<Object>{
    const params = new HttpParams()
      .set('sort', "description")
      .set('page', "2");
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');
    return this.httpClient.put(`${this.Url}`, agence, {'params': params, 'headers': headers})
      .pipe(
        map((response) => {
          return response;
        }),
        catchError((error) => {
          console.log('Error caught in service');
          console.error(error);
          throw error;
        })
      );
  }

  public getAgence(nom: String) {
    return this.httpClient.get<Agence[]>(`${this.Url}/page-query=${nom}&_limit=10`, 
    {observe: 'response'});
  }


  // manage error handling
  private handleHttpError(err: HttpErrorResponse) {
    let error: string;
    if (err.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', err.error.message);
      error = `An error occurred: ${err.error.message}`;
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${err.status}, ` +
        `body was: ${err.error}`
      );
      error = `Backend returned code ${err.status}, body was: ${err.error}`;
    }
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.'
      + '\n'
      + error
    );
  }
  
}

