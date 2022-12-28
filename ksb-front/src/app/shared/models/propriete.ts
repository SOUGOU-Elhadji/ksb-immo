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
    numeroLot!: string;
    apporteurAffaire!: string;
    proprietaire!: Proprietaire;
    dateDisponibilite!: Date;
}
