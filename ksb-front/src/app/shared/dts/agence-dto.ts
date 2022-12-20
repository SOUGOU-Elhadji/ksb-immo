import { Employee } from "../models/employee";

export class AgenceDto {
    id!: string;
    nom!: string;
    adresse!: string;
    region!: string;
    departement!: string;
    telephone!: string;
    employees!: Employee[];
}
