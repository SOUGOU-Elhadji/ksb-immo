import { Role } from "../enums/role";
import { Propriete } from "./propriete";
import { Utilisateur } from "./utilisateur";

export class Proprietaire {
    id!: string;
    nom!: string;
    prenom!: string;
    adresse!: string;
    telephone!: string;
    email!: string;
    username!: string;
    password!: string;
    role!: Role;
    profession!: string;
    cni!: string;
    dateDelivrance!: Date;
    dateNaissance!: Date;
    numCompteBancaire!: string;
    proprietes!: Array<Propriete>;
    dateCreation!: Date;
    dateModification!: Date;
    createdBy!: string;
    modifiedBy!: string;
    deleted!: Boolean;
    deletedBy!: string;
    dateDeleted!: Date;
}
