import { Employee } from "./employee";

export class Agence {
    id!: number;
    nom!: string;
    adresse!: string;
    region!: string;
    departement!: string;
    ville!: string;
    telephone!: string;
    dateCreation!: Date;
    employees!: Array<Employee>;
}
