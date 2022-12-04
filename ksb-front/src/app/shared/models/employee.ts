import { Agence } from "./agence";

export class Employee {
    id!: string;
    matricule!: string;
    nom!: string;
    prenom!: string;
    telephone!: string;
    email!: string;
    cni!: string;
    adresse!: string;
    numCompteBancaire!: string;
    manager!: Boolean;
    // agence!: Agence;
}
