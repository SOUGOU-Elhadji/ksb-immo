import { Employee } from "../models/employee";

export class AgenceDto {
    id!: number;
    nom!: string;
    adresse!: string;
    region!: string;
    departement!: string;
    // ville!: string;
    telephone!: string;
    dateCreation!: Date;
    employees!: Employee[];
}
