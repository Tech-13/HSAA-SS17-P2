package logik;

/**
 * Beschreiben Sie hier die Klasse KI_Aanalyse.
 * 
 * Tech 13 
 * 0.0.4
 */
public class KI_Aanalyse
{
    //Würfel Input [In Bearbeitung]
int Würfel1;
int Würfel2;
int Würfel3;
int Würfel4;
int Würfel5;

//Coverter für Array  [In Planung]
int Z1;
int Z2;
int Z3;
int Z4;
int Z5;

// Analyse Variablen
int Points1er;	int EINer;
int Points2er;	int ZWEIer;
int Points3er;	int DREIer;
int Points4er;	int VIERer;
int Points5er;	int FÜNFer;
int Points6er;	int SECHSERer;

int KleineStraße;
int  GroßeStraße;

int Points3erPash;
int DREIerPash;
int Points4erPash;	
int VIERerPash;
int PointsChance;
int Kniffel;
int FullHouse;

int Count;
int CountForward;
int CountBackward;

//Array Sortiert * 
int[] Sorted;

//1-6er
    public int KI_Aanalyse_X_er ()
    {
    
	if(Sorted[0] == 1)// Prüfe-1er
	   {
	   EINer = 1;
	   for (int Count = 0; Count < 4; Sorted[Count]=1)
	   {Count++;}
	   Points1er =Count*1;
	   }
	if (Sorted[0] == 2)// Prüfe-2er
	   {
	    ZWEIer = 1;
	    for (int Count = 0; Count < 4; Sorted[Count]=2)
	    {Count++;}
	    Points1er = Count*2;	
	   }
	if (Sorted[0] == 3)// Prüfe-3er
	   {
	   DREIer = 1;
	   for (int Count = 0; Count < 4; Sorted[Count]=3)
	   {Count++;}
	   Points1er =Count*3;		
	   }
	if (Sorted[0] == 4)// Prüfe-4er
	   {
	    VIERer= 1;
	    for (int Count = 0; Count < 4; Sorted[Count]=4)
	    {Count++;}
	    Points1er =Count*4;
	   }
	if (Sorted[0] == 5)
	   {
	   FÜNFer = 1;
	   for (int Count = 0; Count < 4; Sorted[Count]=5)
	   {Count++;}
	   Points1er =Count*5;
	   }
	if (Sorted[0] == 6)
	   {
	   SECHSERer = 1;
	   for (int Count = 0; Count < 4; Sorted[Count]=6)
	   {Count++;}
	   Points1er =Count*6;
	   }
	   return (31);
    	}
	
//Große Straße	
    public int KI_Analyse_GStraße()// Prüfe auf G-Straße
    {    
     if( Sorted[0]==1 && Sorted[1]==2 && Sorted[2]==3 && Sorted[3]==4 && Sorted[4]==5 )
        {GroßeStraße =1;}
     else
        {GroßeStraße =0;}
        return (321);
    }
	
//Kleine Straße    
    public int KI_Analyse_KStraße()// Prüfe auf K-Straße
    {
     if ( Sorted[0]==1 && Sorted[1]==2 && Sorted[2]==3 && Sorted[3]==4 && Sorted[4]==5 )
        {KleineStraße =1;}
     if ( Sorted[0]==5 && Sorted[1]==4 && Sorted[2]==3 && Sorted[3]==2 && Sorted[4]==1 )
        {KleineStraße =1;}
     else
        {KleineStraße =0;}
        return (322);
    }
    
//3er Pash        
    public int KI_Aanalyse_3erPash()
    {
     if ( Sorted[0] == Sorted[1] && Sorted[0] == Sorted[2] )
        {
        DREIerPash = 1;
        Points3erPash = (Sorted[0] + Sorted[1] + Sorted[2] + Sorted[3] + Sorted[4]);        
        }
     if ( Sorted[4] == Sorted[3] && Sorted[4] == Sorted[2] )
        {
        DREIerPash = 1;
        Points3erPash = (Sorted[0] + Sorted[1] + Sorted[2] + Sorted[3] + Sorted[4]);        
        }
     else
        DREIerPash = 0;
        return (333);
    }
//4er Pash
    public int KI_Aanalyse_4erPash()
    {
    if ( Sorted[0] == Sorted[1] && Sorted[0] == Sorted[2] && Sorted[0] == Sorted[3] )
        {
        VIERerPash = 1;
        Points4erPash = (Sorted[0] + Sorted[1] + Sorted[2] + Sorted[3] + Sorted[4]);    
        }
    if ( Sorted[4] == Sorted[3] && Sorted[4] == Sorted[2] && Sorted[4] == Sorted[1] )
        {
        VIERerPash = 1;
        Points4erPash = (Sorted[0] + Sorted[1] + Sorted[2] + Sorted[3] + Sorted[4]);    
        }
    else
    VIERerPash = 0;
       return (334);
    }
//5er Pash aka. Kniffel    
    public int KI_Aanalyse_Kniffel()// Prüfe auf Kniffel (5er Pash)
    {
    if(Sorted[0] == Sorted[1] && (Sorted[0]) == (Sorted[2]) && (Sorted[0]) == (Sorted[3])  && (Sorted[0]) == (Sorted[4]) )
	{
	Kniffel = 1;	
	}
	else
	Kniffel = 0;	
	   return (34);
    }
//Full House    
    public int KI_Aanalyse_Fullhouse()
    {    
    if ( (Sorted[0]) == (Sorted[1]) && ((Sorted[0]) != (Sorted[2])) && (Sorted[2]) == (Sorted[3]) && (Sorted[2]) == (Sorted[4]) )
    {
    FullHouse = 1;
    }
    if ( Sorted[4] == (Sorted[3]) && (Sorted[4] != Sorted[2]) && Sorted[2] == Sorted[1] && Sorted[2] == Sorted[1] )
    {
    FullHouse = 1;
    }
    else
    FullHouse = 0;
       return (35);
}
