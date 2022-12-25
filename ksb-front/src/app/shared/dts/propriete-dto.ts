import { ApporteurDto } from "./apporteur-dto";


export class ProprieteDto{

    type!: string;
    description!: string;
    adresse!: string;
    prix!: number;
    surface!: number;
    numeroLot !: string;
    nbrePiece!: number;
    nbreChambre!: number;
    nbreSalleDeBain!: number;
    nbreToilette!: number;
    nbreEtage!: number;
    nbreAppartementParEtage!: number;
    meuble!: boolean;
    garage!: boolean;
    piscine!: boolean;
    jardin!: boolean;
    ascenseur!: boolean;
    apporteurAffaire!: ApporteurDto;
    agenceId!: string;
    dateDisponibilite!: string;
    proprietaireId!: string;


}