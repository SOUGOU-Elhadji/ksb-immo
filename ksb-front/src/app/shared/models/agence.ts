import { Employee } from "./employee";

export class Agence {
    id!: number;
    nom!: string;
    adresse!: string;
    region!: string;
    departement!: string;
    telephone!: string;
    dateCreation!: Date;
    employees!: Employee[];
}
