import { Role } from "../enums/role";

export class Utilisateur {
    id!: number;
    username!: string;
    password!: string;
    role!: Role;
}
