
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
    public int KI_Aanalyse_Straße()// Prüfe auf G/K-Straße
    {
        KleineStraße = 0;
		 GroßeStraße = 0;
    for(int CountForward =0; CountForward < 4;) //Straße Hoch
		{ CountForward++; }
		if(CountForward == 4) { KleineStraße = 1;}
		if(CountForward == 5) {  GroßeStraße = 1;}	
	for(int CountBackward =5; CountBackward > 4;) //Straße Runter
		{ CountBackward--; }
		if(CountBackward == 4) { KleineStraße = 1;}
		if(CountBackward == 5) {  GroßeStraße = 1;}
		return (32);
        }
        
    public int KI_Aanalyse_Pash()//Prüfe auf Pash
    {
    if ( (Sorted[0]) == (Sorted[1]) && (Sorted[0]) == (Sorted[2]) )
	{
	DREIerPash = 1;
	Points4erPash = (Sorted[0] + Sorted[1] + Sorted[2] + Sorted[3] + Sorted[4]);		
	}
	else
	DREIerPash = 0;
	if (Sorted[0] == Sorted[1] && (Sorted[0]) == (Sorted[2]) && (Sorted[0]) == (Sorted[3]) )
	{
	VIERerPash = 1;
	Points4erPash = (Sorted[0] + Sorted[1] + Sorted[2] + Sorted[3] + Sorted[4]); 	
	}
	else
	VIERerPash = 0;
	   return (33);
    }
    
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
    
    public int KI_Aanalyse_Fullhouse()
    {    
    if ( (Sorted[0]) == (Sorted[1]) && ((Sorted[0]) != (Sorted[2])) && (Sorted[2]) == (Sorted[3]) && (Sorted[2]) == (Sorted[4]) )
	{
	FullHouse = 1;
	}
	else
	FullHouse = 0;
	   return (35);
    }
}
