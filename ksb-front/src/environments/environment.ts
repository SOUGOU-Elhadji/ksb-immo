// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  apiAgence: 'http://localhost:8080/api/agence',
  apiEmployee: 'http://localhost:8080/api/employee',
  apiProprietaire: 'http://localhost:8080/api/proprietaire',
  apiLoyer: 'http://localhost:8080/api/loyer',
  apiLocataire: 'http://localhost:8080/api/locataires',
  apiMensualite: 'http://localhost:8080/api/mensualite',
  apiPropriete: 'http://localhost:8080/api/propriete',
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
