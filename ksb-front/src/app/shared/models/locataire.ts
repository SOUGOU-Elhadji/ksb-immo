import { Loyer } from "./loyer";
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
    garant!: Locataire;
    numCompteBancaire !: String;
    loyer !: Loyer;
}
