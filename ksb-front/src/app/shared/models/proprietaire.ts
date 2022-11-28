import { Propriete } from "./propriete";
import { Utilisateur } from "./utilisateur";

export class Proprietaire extends Utilisateur{
    id!: number;
    nom!: string;
    prenom!: string;
    adresse!: string;
    telephone!: string;
    email!: string;
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
