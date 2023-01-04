import { Agence } from "../models/agence";

export class EmployeeDto{
    id!: string;
    nom!: string;
    prenom!: string;
    matricule!: string;
    telephone!: string;
    email!: string;
    cni!: string;
    dateDelivranceCni!: string;
    adresse!: string;
    numCompteBancaire!: string;
    manager!: boolean;
    // agenceId!: Agence;
    agenceId?: Pick<Agence, 'id' | 'nom'> | null;
}