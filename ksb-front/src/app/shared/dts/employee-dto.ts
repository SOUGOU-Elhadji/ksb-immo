import { Agence } from "../models/agence";

export class EmployeeDto{
    id!: number;
    nom!: string;
    prenom!: string;
    telephone!: string;
    email!: string;
    cni!: string;
    dateDelivranceCni!: string;
    adresse!: string;
    numCompteBancaire!: string;
    manager!: boolean;
    agenceId!: Agence;
}