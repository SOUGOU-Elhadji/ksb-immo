import { Utilisateur } from "./utilisateur";

export class Locataire extends Utilisateur {
    id!: number;
    nom!: string;
    prenom!: string;
    adresse!: string;
    telephone!: string;
    email!: string;
    profession!: string;
    cni!: string;
    conjoint!: Locataire;
}
