import { TypePropriete } from "../enums/type-propriete";
import { Agence } from "./agence";
import { Proprietaire } from "./proprietaire";

export class Propriete {
    id!: number;
    description!: string;
    adresse!: string;
    type!: TypePropriete;
    prix!: number;
    surface!: number;
    nbrePiece!: number;
    nbreChambre!: number;
    nbreSalleDeBain!: number;
    nbreToilette!: number;
    nbreEtage!: number;
    nbreAppartementParEtage!: number;
    meuble!: Boolean;
    garage!: Boolean;
    piscine!: Boolean;
    jardin!: Boolean;
    ascenseur!: Boolean;
    apporteurAffaire!: string;
    proprietaire!: Proprietaire;
    agence!: Agence;
    dateDisponibilite!: Date;
    dateCreation!: Date;
    dateModification!: Date;
    createdBy!: string;
    modifiedBy!: string;
    deleted!: Boolean;
}
