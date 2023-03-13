package com.mmaliga.utils;

public abstract class Sim {

	public static final int BIGRANDOM = 20;
	public static final int SMALLRANDOM = 10;
	public static final int DAMAGECUT = 25;
	public static final int KOPROBCUT = 40;
	public static final double KOFREQUENCY = 1.1;
	public static final int TKORUSHMINIMUN = 2;
	public static final int TKOMINHITPOINTS = 30;
	public static final int TKOFREQUENCY = 9;
	public static final int SUBDIFFICULT = 22;
	public static final double SUBDEFENSECUT = 1.5;
	public static final int SUBMALUS = 9;
	public static final int REFSUBFREQUENCY = 9;
	public static final double NINECMDIFFERENCE = 0.75;
	public static final double ONEWEIGHTCLASSDIFFERENCE = 0.75;
	public static final int STRENGTHONEWEIGHTCLASSDIFERENCE = 1;
	public static final int LEVEL2SKILL = 12;
	public static final int LEVEL3SKILL = 15;
	public static final int COUNTERATTACKCUT = 2;
	public static final int FATIGUECUT = 1;
	public static final int TIMEADVANCE = 15;
	public static final int HURTFACTOR = 1;
	public static final int MAXRUSH = 6;
	public static final int BREAKCLINCHFREQUENCY = 5;
	public static final int BREAKCLINCHPROB = 10;
	public static final double MAXDAMAGEFORCHANGINGGAMEPLAN = 12.5;
	public static final double STRIKESFROMGUARDDAMAGECUT = 2.5;
	public static final int MINCUTSBLEEDING = 2;
	public static final int DOCTORCHECKCUTSFREQUENCY = 25;
	public static final int DOCTORSTOPPAGE = 20;
	public static final int MINACTIONSFORSWITCHING = 3;
	public static final int DIRTYMOVEMALUSCUT = 20;
	public static final int PULLGUARDCUT = 6;
	public static final int CAPITALIZEPROB = 10;
	public static final int MINSROUNDSINTHEGROUND = 3;
	public static final int FANCY_MOVE_ATTEMP_EXCITEMENT_BONUS = 5;
	public static final int FANCY_MOVE_SUCCESS_EXCITEMENT_BONUS = 20;
	public static final int SLAM_EXCITEMENT_BONUS = 10;
	public static final int UPSET_FREQUENCY = 5;

	// Moral min/max
	public static final int MAXMORAL = 20;
	public static final int MINMORAL = 1;
	public static final int MAXLATESTRESULTS = 5;
	public static final int MINLATESTRESULTS = -3;
	public static final int MAXFIGHTPERFORMANCE = 3;
	public static final int MINFIGHTPERFORMANCE = -3;
	public static final int MAXFEARMANAGEMENT = 3;
	public static final int MINFEARMANAGEMENT = -3;
	public static final int MAXPAINANDTIREDNESS = 1;
	public static final int MINPAINANDTIREDNESS = -5;
	public static final int FEARMANAGEMENTCUT = 40;
	public static final int RANKINGCUT = 2;
	public static final double RANKINGWEIGHTCLASS = 0.15;
	public static final int MOTIVATIONEDGE = 12;
	public static final int MOTIVATIONCUT = 6;

	public static final int SMALLINJURIES = 50;
	public static final int BIGINJURIES = 175;
	public static final int INJURYCUT = 22;
	public static final int SMALLINJURYORCUTTRUE = 1;
	public static final int BIGINJURYORCUTTRUE = 2;
	public static final int INJURYORCUTFALSE = 0;

	public static final int MOVECOMMMENTSFREQUENCY = 8;

	public static final int SOCCERKICKSFREQUENCY = 2;
	public static final int STOPMSFREQUENCY = 3;
	public static final int KNEESFREQUENCY = 3;

	public static final int RESTFREQUENCY = 40;
	public static final int ACTIONFREQUENCY = 18;

	// Styles mod
	public static final double DEFAULTSTAMINARECOVERY = 0.33;
	public static final double ACTIVEFIGHTERSTAMINALOSS = 1.1;
	public static final int DEFAULTSTAMINALOSS = 10;
	public static final int STAMINACUT = 10;

	public static final int DEFAULTFIGHTERSTAMINALOSS = 1;
	public static final double AGGLEVEL1STAMINALOSS = 1.1;
	public static final double AGGLEVEL2STAMINALOSS = 1.2;
	public static final double DEFLEVEL1STAMINALOSS = 0.9;
	public static final double DEFLEVEL2STAMINALOSS = 0.8;

	public static final int DEFAULTACCURACY = 0;
	public static final int TECHLEVEL1ACCURACY = 1;
	public static final int TECHLEVEL2ACCURACY = 3;
	public static final int PWRLEVEL1ACCURACY = -2;
	public static final int PWRLEVEL2ACCURACY = -5;

	public static final int DEFAULTDEFLEVEL = 0;
	public static final int DEFLEVEL1DEFLEVEL = 1;
	public static final int DEFLEVEL2DEFLEVEL = 2;
	public static final int AGGLEVEL1DEFLEVEL = -1;
	public static final int AGGLEVEL2DEFLEVEL = -2;

	public static final int AGGLEVEL1INITMOD = 4;
	public static final int AGGLEVEL2INITMOD = 8;
	public static final int DEFLEVEL1INITMOD = -4;
	public static final int DEFLEVEL2INITMOD = -8;
	public static final int DEFAULTINITMOD = 0;

	public static final int DEFAULTAGGPOWER = 0;
	public static final int AGGLEVEL1DAMAGEMOD = 3;
	public static final int AGGLEVEL2DAMAGEMOD = 5;

	public static final double PWRLEVEL1INITMOD = 1.5;
	public static final double PWRLEVEL2INITMOD = 3.5;
	public static final int TECHLEVEL1INITMOD = -1;
	public static final int TECHLEVEL2INITMOD = -2;

	public static final int TECHLEVEL1DAMCUT = -2;
	public static final int TECHLEVEL2DAMCUT = -5;
	public static final int PWRLEVEL1DAMCUT = 5;
	public static final int PWRLEVEL2DAMCUT = 8;
	public static final int DEFAULTDAMAGECUT = 0;

	public static final int FANCYMOVEPROB = 2;
	public static final int KICKMALUS = 1;
	public static final double KICKDAMAGEBONUS = 1.5;
	public static final int CLINCHMALUS = 3;

	public static final int SLAMSTRENGTH = 15;
	public static final int SLAMPROB = 2;
	public static final int MAXLOCKINSUBMISSION = 10;

	public static final int SUPPLEXSTRENGHT = 15;
	public static final int SUPPLEXPROB = 1;

	public static final int DANGEROUSCOMMENT = 14;

	// Point system
	public static final int FULLMOUNTPOSPOINTS = 2;
	public static final int CLOSEDGUARDPOSPOINTS = 1;
	public static final int SUCCESSFULTAKEDOWNPOINTS = 5;
	public static final int LOCKINSUBMISSIONPOINTS = 5;
	public static final int KNOCKDOWNPOINTS = 3;
	public static final int MORESTRIKESPOINTS = 5;
	public static final int ATTACKLEVELPOINTS = 2;
	public static final int DAMAGECUTPOINTS = 10;
	public static final int EIGHTPOINTSCRITERIA = 4;
	public static final int MOVEPOINTS = 1;

	public static final int JUDGEPOINTINGCRITERIA = 9;

	public static final double REFTENDENCYTOSTANDUP = 2.5;

	// Rankings
	public static final double HIGHERRANKING = 2;
	public static final double RANKINGPERCENTAGE = 0.08;
	public static final double RANKINGPERCENTAGEHIGH = 0.12;
	public static final double RANKINGPERCENTAGELOW = 0.05;
	public static final double RANKINGPERCENTAGELOSS = 0.05;
	public static final double RANKINGPERCENTAGELOSSSHIGH = 0.1;
	public static final double RANKINGPERCENTAGELOSSSLOW = 0.03;

	// Fight outcomes
	public static final int RES_KO = 0;
	public static final int RES_SUB = 1;
	public static final int RES_INJURY = 2;
	public static final int RES_DISQ = 3;
	public static final int RES_TIMEOUT = 4;
	public static final int RES_RDRAW = 5;
	public static final int RES_NC = 6;
	public static final int RES_TKO = 7;
	public static final int RES_CUT = 8;

	// Other
	public static final double FOOT = 30.48;
	public static final double INCH = 2.54;
	public static final double LBS = 453.59;

	// Cons Comments
	public static final int GO_TO_THE_JUDGES = 0;
	public static final int JUDGE = 1;
	public static final int WINNER_IS = 2;
	public static final int DECISION = 3;
	public static final int SPLIT_DECISION = 4;
	public static final int MAJORITY_DECISION = 5;
	public static final int MAJORITY_DRAW = 6;
	public static final int DRAW = 7;
	public static final int BY = 8;
	public static final int BETWEEN = 9;
	public static final int ANDD = 10;
	public static final int PUNCHES = 11;
	public static final int KICKS = 12;
	public static final int TAKEDOWNS = 13;
	public static final int CLINCH_STRIKES = 14;
	public static final int SUBMISSIONS = 15;
	public static final int GNP_STRIKES = 16;
	public static final int STATISTICS = 17;
	public static final int DAMAGE_DONE = 18;
	public static final int TIME_ON_THE_GROUND = 19;
	public static final int FOREHEAD = 20;
	public static final int LEFT_EYE = 21;
	public static final int RIGHT_EYE = 22;
	public static final int LEFT_CHEEK = 23;
	public static final int RIGHT_CHEEK = 24;
	public static final int NOSE = 25;
	public static final int MOUTH = 26;
	public static final int CHIN = 27;
	public static final int UPPER_BODY = 28;
	public static final int RIBS = 29;
	public static final int ABDOMEN = 30;
	public static final int BACK = 31;
	public static final int LEFT_ARM = 32;
	public static final int RIGHT_ARM = 33;
	public static final int LEFT_TIGH = 34;
	public static final int RIGHT_TIGH = 35;
	public static final int LEFT_KNEE = 36;
	public static final int RIGHT_KNEE = 37;
	public static final int LEFT_FOOT = 38;
	public static final int RIGHT_FOOT = 39;
	public static final int KO = 40;
	public static final int TKO = 41;
	public static final int SUB = 42;
	public static final int INJ = 43;
	public static final int NC = 44;
	public static final int DQ = 45;
	public static final int TIMEOUT = 46;
	public static final int FRECORD = 47;
	public static final int GRAPPLING = 48;
	public static final int CLINCH_DAMAGE = 49;
	public static final int GROUND_DAMAGE = 50;
	public static final int AVERAGE_DAMAGE = 51;
	public static final int CAUSED = 52;
	public static final int RECEIVED = 53;
	public static final int DAMAGE = 54;
	public static final int CUT = 55;
	public static final int DOCTOR_STOPPAGE = 56;
	public static final int REF_OF_THE_BOUT = 57;
	public static final int FREAKSHOW = 58;
	public static final int UNFAIR = 59;
	public static final int MISMATCH = 60;
	public static final int FAIR = 61;
	public static final int GREAT_MATCH = 62;
	public static final int VERY_ANTICIPATED = 63;
	public static final int DREAM_MATCH = 64;
	public static final int EVENT_PLACE = 65;
	public static final int ATTENDANCE = 66;
	public static final int PPV_BUYS = 67;
	public static final int PRELIM_CARD_EXC = 68;
	public static final int MAIN_CARD_EXC = 69;
	public static final int MAIN_EVENTS_EXC = 70;
	public static final int OVERALL_QUALITY = 71;
	public static final int FIGHTS_PLAYED = 72;
	public static final int SHW = 73;
	public static final int HW = 74;
	public static final int LHW = 75;
	public static final int MW = 76;
	public static final int WW = 77;
	public static final int LW = 78;
	public static final int FW = 79;
	public static final int BW = 80;
	public static final int BOUT = 81;
	public static final int TKOS = 82;
	public static final int INJURIES = 83;
	public static final int DECISSION = 84;
	public static final int DISQUALIFICATION = 85;
	public static final int AVERAGE_DURATION = 86;
	public static final int MOST_USED_REF = 87;
	public static final int MOST_USED_ORG = 88;
	public static final int TOTAL_DURATION = 89;
	public static final int ANY_ORGANIZATION = 90;
	public static final int UNKNOWN = 91;
	public static final int BREAK_RECORD = 92;
	public static final int MORE_DAMAGE_FIGHT = 93;
	public static final int MORE_DAMAGE_HIT = 94;
	public static final int FASTEST_KO = 95;
	public static final int FASTEST_SUB = 96;
	public static final int N_ROUND = 97;
	public static final int PREVIOUS_FIGHTS = 98;
	public static final int WON_BEFORE = 99;
	public static final int NEVER_BEFORE = 100;
	public static final int LOST_BEFORE = 101;
	public static final int TOWEL_THROW = 102;
	public static final int GOIN_KICK = 103;
	public static final int EYE_POKE = 104;
	public static final int HEADBUTT = 105;
	public static final int STRANGLE = 106;
	public static final int DEFENDS_TITLE = 107;
	public static final int WINS_TITLE = 108;
	public static final int TIE_BREAK_ROUND = 109;
	public static final int WIN_RANKING_POINTS = 110;
	public static final int LOSE_RANKING_POINTS = 111;
	public static final int BEST_FIGHT = 112;
	public static final int WORST_FIGHT = 113;
	public static final int WINNING_STREAK = 114;
	public static final int LOSING_STREAK = 115;
	public static final int VERY_BORING = 116;
	public static final int DULL = 117;
	public static final int AVERAGE = 118;
	public static final int PROMISING = 119;
	public static final int EXCITING = 120;

	//Fight
	public static final int ACT_PUNCHES = 1;
	public static final int ACT_KICKS = 2;
	public static final int ACT_CLINCH = 3;
	public static final int ACT_TAKEDOWNS = 4;
	public static final int ACT_DIRTYBOXING = 5;
	public static final int ACT_THAICLINCH_PUNCHES = 6;
	public static final int ACT_TAKEDOWNCLINCH = 7;
	public static final int ACT_BREAKCLINCH = 8;
	public static final int ACT_GNP = 9;
	public static final int ACT_POSITIONING = 10;
	public static final int ACT_SUBMISSION = 11;
	public static final int ACT_STANDINGSUB = 12;
	public static final int ACT_STANDUP = 13;
	public static final int ACT_LNP = 14;
	public static final int ACT_FANCYPUNCH = 15;
	public static final int ACT_FANCYKICK = 16;
	public static final int ACT_HEADBUTT = 17;
	public static final int ACT_BITE = 18;
	public static final int ACT_POKE = 19;
	public static final int ACT_REST = 20;
	public static final int ACT_GROINKICK = 21;
	public static final int ACT_SLAM = 22;
	public static final int ACT_SUPPLEX = 23;
	public static final int ACT_SOCCERKICKS = 24;
	public static final int ACT_STOMPS = 25;
	public static final int ACT_STANDKICK = 26;
	public static final int ACT_MOVETOGROUND = 27;
	public static final int ACT_STRIKESFROMGUARD = 28;
	public static final int ACT_GROUNDKICK = 29;
	public static final int ACT_RESTCLINCH = 30;
	public static final int ACT_NOACTION = 31;
	public static final int ACT_ALLOWSTAND = 32;
	public static final int ACT_PUNCHEXCHANGE = 33;
	public static final int ACT_PULLGUARD = 34;
	public static final int ACT_GNPELBOWS = 35;
	public static final int ACT_CAPITALIZESTAND = 36;
	public static final int ACT_CAPITALIZEGROUND = 37;
	public static final int ACT_KNEESONGROUND = 38;
	public static final int ACT_FANCYSUB = 39;
	public static final int ACT_THAICLINCH_KNEES = 40;
	public static final int ACT_GRAPPLING_KNEE = 41;
	public static final int ACT_GRAPPLING_PUNCH = 42;

	//Takedowns
	public static final int JUDO = 1;
	public static final int WRESTLING = 2;

	// Clinch Attack
	public static final int THAI_ATTACK = 1;
	public static final int DIRTY_BOXING = 2;
	public static final int GRAPPLING_ATTACK = 3;

	//Guards
	public static final int REAR_MOUNT = 0;
	public static final int FULL_MOUNT = 1;
	public static final int SIDE_MOUNT = 2;
	public static final int HALF_GUARD = 3;
	public static final int OPEN_GUARD = 4;
	public static final int CLOSED_GUARD = 5;
	public static final int BUTTERFLY_GUARD = 6;

	//Clinch
	public static final int CLINCH_DIRTY_BOXING = 0;
	public static final int THAI_CLINCH = 1;
	public static final int SIMPLE_GRAPPLING = 2; 
	
	public static String UNKNOWN_STR = "Unknown";
	
	public static int setLimits(int actual, int max, int min) {
	    if (actual > max) {
	        actual = max;
	    } else if (actual < min) {
	        actual = min;
	    }
	    return actual;
	}
	
}
