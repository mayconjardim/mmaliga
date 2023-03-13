package com.mmaliga.utils;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Comments {

	public static final ArrayList<String> apresentation = new ArrayList<String>(Arrays.asList(

			"Senhoras e senhores. Essa luta é de %d rounds, na divisão dos %s! %n"
					+ "Apresentando o lutador à minha esquerda, lutando no córner vermelho. %n"
					+ "Com um cartel de %s-%s-%s, %s! %n"
					+ "E apresentando o lutador à minha direita, lutando pelo córner azul. %n"
					+ "Com um cartel de %s-%s-%s, %s! %n",

			"Senhoras e senhores. Essa luta é de %d rounds, pelo cinturão dos  %s! %n"
					+ "Apresentando o campeão à minha esquerda, lutando no canto vermelho. %n"
					+ "Com um cartel de %s-%s-%s, %s! %n"
					+ "E apresentando o desafiante à minha direita, lutando no canto azul. %n"
					+ "Com um cartel de %s-%s-%s, %s! %n"));

	public static final ArrayList<String> punch1 = new ArrayList<String>(Arrays.asList(
			"%act tries a hook to the body;and hits %pas's ribs hard;but %pas manages to dodge it;10;1;2;3;Hook to the body;1;1;-10;0;-5;1;1",
			"%act fakes a move and launches a nice uppercut;it lands on %pas's chin;%pas blocks that. It was easy!;8;2;3;2;Uppercut;1;1;0;0;2;1;1;",
			"Brilliant combination from %act;that forces %pas to try and defend better.;%pas is showing some dodging skills avoiding that ones.;7;2;1;3;Punches;4;3;2;2;1;1;1",
			"Bone shattering straight right hand from %act!;%pas is going to have a big headache after that blow!;%pas ducks under...;4;1;2;4;Punch;1;1;1;1;1;1;1",
			"Bone shattering straight left hand from %act!;%pas is going to have a big headache after that blow!;%pas ducks under...;5;1;2;4;Punch;1;1;1;1;1;1;1",
			"Tremendous strikes from %act!;Some big punches are landing!;%pas blocks with confidence;8;3;1;2;Punches;3;3;2;2;3;1;1",
			"%act launches a hook to the body;Bang! %pas stops that one with his ribs!;%pas moves aside looking for a counter...;10;4;1;2;Punch;1;1;0;2;0;1;1",
			"%act throws a punch;that finds an opening in the defense of %pas.;that gets deflected.;0;2;1;2;Punch;1;1;0;0;0;1;1",
			"Solid jabs from %act.;Nice punches.;%pas defends.;0;1;1;2;Jabs;2;2;-1;-2;-1;1;1",
			"A solid combination from %act;connects with %pas.;mostly hits air.;0;2;1;2;Punches;2;2;1;0;0;1;1",
			"%act is measuring %pas with his jab.;Good accuracy on his part.;%pas isn't fazed.;0;1;1;2;Jabs;2;2;-1;-2;-1;1;1",
			"Solid shot from %act to the body.;%pas didn't like that.;%pas blocks in time.;9;2;1;4;Body punch;1;1;-5;1;0;1;1",
			"Some counter punches against %pas; %location;almost hit him as he moves away.;0;1;4;1;Punches;2;2;0;-1;0;1;1",
			"Good movement from %act;moving in to strike and moving away afterwards.;who is bobbing and weaving.;0;0;1;3;Punches;2;2;1;0;0;1;1",
			"%act fires an unorthodox punch to %pas's torso;that hits its mark.;that goes wide.;11;2;1;2;Body punch;1;1;-5;-1;-3;1;1",
			"A punch from %act;grazes %pas's left cheek.;whizzes past %pas.;4;2;1;4;Punch;1;1;0;-1;0;1;1",
			"A punch from %act;grazes %pas's right cheek.;gets blocked by %pas.;5;2;1;4;Punch;1;1;0;-1;0;1;1",
			"%act jabs at %pas;hitting his chest.;to no visible effect.;9;2;1;2;Jab;1;1;-5;-1;-2;1;1",
			"%act launches a flurry of punches;but only manages to land glancing blows.;%pas slips out of danger.;0;3;1;3;Punches;3;2;0;-1;0;1;1"
	));

	public static final ArrayList<String> punch2 = new ArrayList<String>(Arrays.asList(
			"%act tries a hook to the body;and hits %pas's ribs hard;but %pas manages to dodge it",

			"%act fakes a move and launches a nice uppercut;it lands on %pas's chin;%pas blocks that. It was easy!",

			"Brilliant combination from %act;that forces %pas to try and defend better.;%pas is showing some dodging skills avoiding that ones.",

			"Bone shattering straight right hand from %act!;%pas is going to have a big headache after that blow!;%pas ducks under...",

			"Bone shattering straight left hand from %act!;%pas is going to have a big headache after that blow!;%pas ducks under...",

			"Tremendous strikes from %act!;Some big punches are landing!;%pas blocks with confidence",

			"%act launches a hook to the body;Bang! %pas stops that one with his ribs!;%pas moves aside looking for a counter...",

			"%act throws a punch;that finds an opening in the defense of %pas.;that gets deflected.",

			"Solid jabs from %act.;Nice punches.;%pas defends.",

			"A solid combination from %act;connects with %pas.;mostly hits air.",

			"%act is measuring %pas with his jab.;Good accuracy on his part.;%pas isn't fazed.",

			"Solid shot from %act to the body.;%pas didn't like that.;%pas blocks in time.",

			"Some counter punches against %pas; land while he's on his bicycle.;almost hit him as he moves away.",

			"Good movement from %act;moving in to strike and moving away afterwards.;who is bobbing and weaving.",

			"%act fires an unorthodox punch to %pas's torso;that hits its mark.;that goes wide.",

			"A punch from %act;grazes %pas's left cheek.;whizzes past %pas.",

			"A punch from %act;grazes %pas's right cheek.;gets blocked by %pas.",

			"%act jabs at %pas;hitting his chest.;to no visible effect.",

			"%act launches a flurry of punches;but only manages to land glancing blows.;%pas slips out of danger."
	
	));

	public static final ArrayList<String> punch3 = new ArrayList<String>(Arrays.asList(

	));

	public static final ArrayList<String> kicks1 = new ArrayList<String>(Arrays.asList(
			"Low kick by %act to maintain his distance.;That hits %pas's ankle;Bad move. That was far from landing.;17;3;1;2;Low kick;1;1;-5;-5;0;1;1",

			"Low kick by %act to maintain his distance.;That hits %pas's ankle;Bad move. That was far from landing.;18;3;1;2;Low kick;1;1;-5;-5;0;1;1",

			"%act moves forward and launches a low kick.;Hard blow to %pas's left thigh;%pas blocks that.;15;2;1;3;Low kick;1;1;-5;-5;0;1;1",

			"%act moves forward and launches a low kick.;Hard blow to %pas's right thigh;%pas blocks that.;16;2;1;3;Low kick;1;1;-5;-5;0;1;1",

			"%act is not showing a great technique with that low kick...;That one finds %pas's thigh;%pas is smart enough to block that one.;16;3;3;1;Low kick;1;1;-5;-5;0;1;1",

			"Body kick by %act...;just grazes his opponent.;is blocked.;11;2;1;2;Body kick;1;1;-5;-5;0;1;1",

			"A high kick from %act;grazes %pas's head, but he seems okay.;falls short of the mark.;0;3;1;4;High kick;1;1;-2;-2;0;1;1",

			"A high kick from %act;glances off %pas.;misses badly. %act slips and falls!;9;0;0;0;High kick;1;1;-1;-2;-2;1;3",

			"A bunch of leg kicks from %act;are bothering his opponent.;are blocked by %pas.;15;2;1;2;Low kicks;3;3;-5;-3;0;1;1",

			"%act throws a body kick.;Solid shot!;Blocked by %pas.;11;2;1;2;Body kick;1;1;-5;-2;0;1;1",

			"Good leg kicks from %act.;%pas winces a bit.;%pas defends with ease.;16;2;1;2;Low kicks;3;3;-5;-3;0;1;1",

			"Every time %pas attempts to get inside;%act fires a low kick.;%act misses with a low kick.;17;3;1;2;Low kicks;2;2;-5;-7;0;1;1",

			"Nice low kick from %act;Loud pop!;but %pas stops it.;15;3;1;2;Low kick;1;1;-5;-5;0;1;1"
			));

	public static final ArrayList<String> kicks2 = new ArrayList<String>(Arrays.asList(
			"%act launches a furious low kick!;%pas receives a hard blow on his left leg!;%pas blocks.;17;1;1;3;Low kick;1;1;-3;0;0;1;1",

			"%act launches a furious low kick!;%pas receives a hard blow on his right leg!;%pas blocks;18;1;1;3;Low kick;1;1;-3;0;0;1;1",

			"Good front kick from %act!;%pas stumbles backwards after that one!;%pas blocks;11;0;1;4;Front kick;1;1;0;0;0;1;1",

			"Lightning fast low kick from %act!;Loud pop! I'm sure that hurts!;%pas blocks that kick with his leg.;16;0;1;3;"
			+ "Low kick;1;1;0;0;0;1;1",

			"%act fakes a move and launches a liver kick!;That almost wrenches %pas! I'm sure that his liver will be sore tomorrow."
			+ ";%pas blocks and pushes his opponent.;10;0;1;4;Middle kick;1;1;0;1;0;1;1",

			"Solid low kick from %act.;For sure, that had to hurt!;%pas deflects it.;15;1;1;2;Low kick;1;1;-3;-3;0;1;1 "
			+ "Middle kick from %act.;%pas receives a solid kick right below his ribs.;The kick just misses.;10;2;1;2;"
			+ "Body kick;1;1;-3;-3;0;1;1",

			"Solid kick to the leg from %act;that visibly pains %pas.;%pas checks it.;17;1;1;2;Low kick;1;1;-3;-1;0;1;1",

			"%act throws a low kick;He switches targets and lands a superb body kick!;%pas blocks.;11;1;2;1;Body kick;1;1;-3;-1;0;1;1",

			"%act fires low kicks;punishing %pas's legs repeatedly.;that fail to land.;15;2;1;2;Low kicks;3;3;-3;-1;0;1;1",

			"Inside leg kick from %act;that lands on %pas's leg.;that goes awry.;16;2;1;4;Low kick;1;1;-3;-2;0;1;1",

			"%act launches a low kick;that almost wrenches %pas's knee!;that gets blocked quickly.;18;2;1;2;Low kick;1;1;-3;0;0;1;1",

			"%act tries a middle kick;%pas blocks with his arm! Wow, that was loud!;%pas blocks and steps away.;14;2;2;4;"
			+ "Middle kick;1;1;-3;-1;0;1;1",

			"%act moves aside and launches a furious low kick!;Hard blow to %pas's thigh!;%pas checks the kick.;16;0;1;2;"
			+ "Kicks;1;1;0;1;-1;0;0;"
			));
	
	public static final ArrayList<String> kicks3 = new ArrayList<String>(Arrays.asList(
			"%act moves forward and launches a high kick!;Vicious high kick!;%pas ducks under.;4;-2;1;3;High kick;1;1;3;3;5;1;1",

			"%act tries a high kick!;%pas was covering for a middle kick but that one almost knocked off his head!;%pas blocks. "
			+ "Wow, that could have finished this match.;4;0;1;2;High kick;1;1;2;2;7;1;1",

			"Here comes %act with a vicious middle kick!;That lands hard on %pas's ribs!;%pas dodges that one moving backwards;"
			+ "10;0;1;4;Middle kick;1;1;0;3;0;1;1",

			"%act steps forward and fires a high kick!;Vicious high kick, I can't believe that landed!;%pas blocks decisively,"
			+ " as if to say, No KO for me, thanks!;0;-1;1;4;High kick;1;1;3;2;5;1;1",

			"A bad move from %pas;allows %act to land a solid head kick.;almost puts his head in the path of %act's kick.;"
			+ "0;1;3;4;High kick;1;1;1;0;3;1;1",

			"%pas moves to shoot;but %act delivers a knee that wrecks him!;%act misses a knee.;0;1;4;3;Knee;1;1;3;2;7;1;1",

			"Brutal-looking high kick from %act!;You could hear the impact from the back seats!;%pas dodges!;0;-1;2;1;High kick;1;1;2;1;6;1;1",

			"%pas attempts a shoot;%act hops back and delivers a powerful kick to his head!;but stops before running into %act's"
			+ " kick.;0;1;4;2;High kick;1;1;2;2;5;1;1",

			"%act wants this win. He unleashes a kick.;Brutal high kick to %pas!;His opponent is elsewhere,"
			+ " looking to counter...;0;3;2;4;High kick;1;1;3;2;5;1;1",

			"High kick from %act!;%pas seems to be done!;He misses narrowly!;0;-2;1;3;High kick;1;1;2;1;7;1;1",

			"%act launches a solid middle kick;that wrenches %pas!;that whizzes past %pas.;11;0;2;4;High kick;1;1;-7;2;0;1;1",

			"%act goes for a low kick..;Faster than a blinking eye, he follows up with a high kick!;%pas avoids "
			+ "the deadly blow.;0;-1;2;4;High kick;2;2;3;3;5;1;1",

			"Incredible high kick!;%pas is worried!;%pas deflects and sidesteps.;9;0;1;2;High kick;1;1;3;3;4;1;1"
			));

	public static final ArrayList<String> dirtyClinch = new ArrayList<String>(Arrays.asList(
			"%act wants to close the range and tries to grapple...;Nice move. He shoves himself over his opponent "
			+ "and secure a single collar tie.;%pas doesn't want anything like this as he moves backwards;0;0;0;0;Dirty Boxing;0;0;0;0;0;12;0;",

			"%act tries to take the action to his favourite field as he tries to grapple;Great move by %act who pushes "
			+ "his opponent forward with a double underhooks.;%pas swings and %act has to retreat;0;0;0;0;Dirty Boxing;0;0;0;0;0;12;0;",

			"%act moves forward looking for some action;He surprises %pas with a double overhooks!;%pas doesn't "
			+ "want to engage and backpedals;0;0;0;0;Dirty Boxing;0;0;0;0;0;0;0;"
			
			));
	
	public static final ArrayList<String> thaiClinch = new ArrayList<String>(Arrays.asList(
			"%act moves forward looking for some grappling action;%act has his opponent in a text book double collar"
			+ " thai clinch!;%pas pushes his opponent and keep the fight at striking range;0;0;0;0;Thai Clinch;0;0;0;0;0;12;0;",

			"%act fakes a punch and launches himself over %pas;Great move by %act who pushes his opponent under a "
			+ "troublesome thai clinch;%pas counters with a few fake punches and then backpedals;0;0;0;0;Thai Clinch;0;0;0;0;0;12;0;",

			"%act jumps over his opponent and tries to grapple;%act pushes his opponent against the %holdSite in a "
			+ "plum position;%pas sees what was coming and ducks under his opponent and moves aside;0;0;0;0;Thai Clinch;0;0;0;0;0;12;0;"
			
			));
	
	public static final ArrayList<String> clinch = new ArrayList<String>(Arrays.asList(
			"%act wants to take the fight to his advantage and tries to clinch.;%act moves forward and holds %pas;%pas wants "
			+ "nothing of that and pushes %act.;0;2;1;3;Clinch;1;1;0;0;0;12;1",

			"%act fakes a punch and launches himself over %pas!;Nice move by %act who clinches and pushes %pas against "
			+ "the %site;%pas is smart enough to avoid the clinch game by %act and pushes him away!;0;2;2;4;Clinch;1;1;0;0;0;12;1",

			"%act tries some clinching in order to control the fight...;Well done. %act is clinching with %pas.;%pas moves "
			+ "backwards and circles around %act.;0;2;3;7;Clinch;1;1;0;0;0;12;1",

			"%act leans forwards and tries to grapple with %pas;%act shows his clinching skills. Both fighters are clinching "
			+ "now.;%pas wants to mantain the distance and ducks that one.;0;2;1;2;Clinch;1;1;0;0;0;12;1",

			"%act tries to grapple;He puts %pas in a double underhook!;%pas moves aside keeping the fight a strinking "
			+ "range;0;0;0;0;Grappling;0;0;0;0;0;12;0;",

			"%act moves forward looking for some action;%act shows some wrestling skills as he put his opponent in a "
			+ "double overhook!;%pas struggles a bit before breaking %act's attemp of grappling;0;0;0;0;Grappling;0;0;0;0;0;12;0;"
			
			));
	
	public static final ArrayList<String> counter = new ArrayList<String>(Arrays.asList(
			"%act is trying to counter now!", "%pas clumsily fails here and it's time for %act to fight back!",
			"%act tries to get some advantage after his opponent miss move...",
			"%pas gets sloppy and %act tries to take advantage...", "Poorly executed technique. %act looks to counter!",
			"%act misses a step and %pas sees an opportunity to counter him!"));
	
	public static final ArrayList<String> takeDown1 = new ArrayList<String>(Arrays.asList(
			"%act is holding %pas's left leg... He's trying to take him down.;%pas loses balance and goes to "
			+ "the ground.;%pas shows great balance while pushing away %act;13;3;1;3;One leg takedown;1;1;0;0;0;13;1",

			"%act is holding %pas's right leg... He's trying to take him down.;%pas loses balance and goes to "
			+ "the ground.;%pas shows great balance while pushing away %act;14;3;1;3;One leg takedown;1;1;0;0;0;13;1",

			"%act grabs his opponent by the waist and tries to take the fight to the ground;Great takedown "
			+ "by %act;%pas struggles... %act is unable to take him down;12;1;3;1;Takedown;1;1;0;0;0;5;1",

			"%act tries to take the fight to the ground with a one leg takedown...;%pas is unable to remain "
			+ "on his feet and falls to the ground;%pas jumps backwards and frees his leg.;12;2;2;3;One leg takedown;1;1;0;0;0;5;1",

			"%act tries to bring the fight to the ground;%pas goes down.;%pas won't budge, forcing %act to "
			+ "pull guard.;12;0;0;0;Takedown;1;1;0;-1;0;5;10",

			"%act shoots for a double leg takedown!;He hits it! %pas is taken off his feet, but he manages "
			+ "to pull %act into his guard.;%pas sprawls and manages to stay on his feet.;12;2;7;3;Double Leg Takedown;1;1;0;0;1;6;1;",

			"%act attempts a sweep single...;%act catches %pas's far ankle and trips him to the mat! Slick"
			+ " takedown by %act.;%pas was ready and shrugs off the takedown attempt.;12;2;2;3;Sweep Single;1;1;0;0;0;6;0;"
			));
	
	public static final ArrayList<String> groundKO = new ArrayList<String>(
			Arrays.asList("This is over! That impact from %act has left %pas laying flat on the mat!",
					"%act turns out the lights for %pas! What an astonishing KO by %act!",
					"That brutal impact left %pas laid out on the mat! %act's corner come in to congratulate him!"));

	public static final ArrayList<String> standingKO = new ArrayList<String>(Arrays.asList(
			"%pas hits the ground hard! That crushing blow from %act has left %pas unconscious! What a finish by %act!",
			"%pas hits the ground like a rag doll! That surgical strike by %act has left %pas unconscious on the mat!",
			"%pas is out! %pas is out! %act has ended this fight in highlight reel fashion!",
			"Down %pas goes! He's out cold! That phenomenal knock out has put the rest of %act's divison on notice!",
			"That brutal impact left %pas laid out on the mat! %act's corner pours in to congratulate him!",
			"Oh! Down goes %pas! %act knocked him stupid! The medics pour in! %act really wanted to win this fight"
					+ " and has done it in an impressive manner.",
			"%act landed the knock out blow that he wanted! %pas is down! %pas has been absolutely destroyed here! A great victory for %act!",
			"%pas hit the ground like he got hit with a baseball bat! %act knocks %pas out cold in a stunning fashion!",
			"%act turns out the lights for %pas! Tiiiiiiiim-ber! What a knock out!",
			"%pas fell like he got shot! This is over!",
			"The frightening power of %act has left %pas sleeping peacefully on the canvas!",
			"%pas crumples to the mat and %act moves in to finish him. The referee jumps in and stops the fight!"));

	public static final ArrayList<String> misc = new ArrayList<String>(Arrays.asList("The fight goes to the judges.",
			"Judge:", "Winner is", "Unanimous decision", "Split decision", "Majority decision", "Majority draw", "Draw",
			"by", "between", "Punches", "Kicks", "Takedowns", "Clinch strikes", "Submissions", "GnP strikes",
			"Statistics", "Damage caused", "Time on the ground", "Forehead", "Left eye", "Right eye", "Left cheek",
			"Right cheek", "Nose", "Mouth", "Chin", "Upper body", "Ribs", "Abdomen", "Back", "Left arm", "Right arm",
			"Left thigh", "Right thigh", "Left Knee", "Right knee", "Left foot", "Right foot", "KO", "TKO",
			"Submission", "Injury", "No contest", "Disqualification", "Time Out", "Record", "Clinch Attempts",
			"Clinch Damage", "Ground Damage", "Average Damage", "Caused", "Received", "Damage", "Cut",
			"Doctor Stoppage", "The referee of the bout is %ref.", "Freakshow", "Unfair", "Mismatch", "Fair",
			"Great Match", "Very Anticipated", "Dream Match", "The event takes place at %venue", "Attendance",
			"PPV buys", "Prelim card excitement", "Main card excitement", "Main and Co-Main event excitement",
			"Overall event quality", "Fights played", "SHW", "HW", "LHW", "MW", "WW", "LW", "FW", "BW", "Bout",
			"(T)KOs", "Injuries", "Decisions", "Disqualification", "Average Duration", "Most used referee",
			"Most used organization", "Total Duration", "Any organization", "Unknown", "%act has broken the record of",
			"most damage caused in a fight", "most damage cause by a single attack", "fastest KO", "fastest submission",
			"Round", "%act has fight %pas %param1 times.", "He has won %param2 of them.",
			"This is the first time they meet inside the %site", "He has lost %param2 of them.", "Towel Throw",
			"groin kick", "eye poke", "headbutt", "strangle", "%act defends the %param1 title!",
			"%act wins the %param1 title!", "Fighters will fight a tie break round.",
			"%act wins %param1 ranking points after the fight.", "%act loses %param1 ranking points after the fight.",
			"%act and %pas had today the best fight of this organization!",
			"%act and %pas had today the worst fight of this organization!",
			"%act comes with a %param1 fight winning streak.", "%act comes with a %param1 fight losing streak.",
			"Very Boring", "Dull", "Average", "Promising", "Exciting"));

	public static final ArrayList<String> tkoRef = new ArrayList<String>(Arrays.asList(
			"%ref has seen enough! The fight is over! %pas was not intelligently defending himself!",
			"The ref pulls off %act! %pas seems confused and a bit dazed as the bell sounds the bout over.",
			"%ref is asking %pas to defend himself! %ref jumps in between the fighters and stops the punishment for %pas."));

	public static final ArrayList<String> faceCut0 = new ArrayList<String>(
			Arrays.asList("%pas has a small cut in his %location;Small cut %location",
					"There is a small laceration on %pas's %location;Small cut %location"));

	public static final ArrayList<String> faceInjuries0 = new ArrayList<String>(Arrays.asList(
			"%pas's %location is beginning to swell;%location swelling",
			"%pas's %location is bruised after the punishement he's received!;%location bruising"
			));
	
	public static final ArrayList<String> faceInjuries1 = new ArrayList<String>(Arrays.asList(
			"%pas can't see anything with that swollen left eye.;Swollen Eye",

			"%pas can't see anything with that swollen right eye.;Swollen Eye",

			"%pas is out! He has a broken orbital bone!;Broken orbital bone",

			"%pas is out! He has a broken cheekbone!;Broken cheeckbone",

			"%pas can't continue fighting. %ref doesn't allow him to continue fighting with his swollen right eye!;Swollen eye",

			"%pas can't continue fighting. %ref doesn't allow him to continue fighting with his swollen left eye!;Swollen eye"
			));
	
	public static final ArrayList<String> bodyInjuries0 = new ArrayList<String>(Arrays.asList(
			"Crushing shot to %pas's body! He's holding his side;Contused side",
			"Hard blow to %pas's mid-section, he seems hurt;Contused side",
			"%pas ribs are getting hammered, they look bad!;Hammered ribs"
			));
	
	public static final ArrayList<String> bodyInjuries1 = new ArrayList<String>(Arrays.asList(
			"%pas has a broken rib. He can't continue fighting.;Broken Rib",
			"%pas may have a broken rib. It's painful to see him losing this way.;Broken Ribs",
			"%pas's holding his side, he appears to be in terrible pain, he's broken a rib ;Broken Ribs"
			));
	
	public static final ArrayList<String> armInjuries1 = new ArrayList<String>(Arrays.asList(
			"%pas [SIDE] arm has been Hyper-extended so much it appears its dislocated, the fight is over;Arm injury",

			"Thats a joint Hyper-extension you don't want, %pas has broken his [SIDE] arm,this fight is over;Broken arm",

			"He hit him so hard %pas has broken his [SIDE] hand;Broken hand "
			+ "It appears %pas broke his [SIDE] wrist with that block;Broken wrist"
			));

	public static final ArrayList<String> legInjuries1 = new ArrayList<String>(Arrays.asList(
			"%pas's [SIDE] leg has been hammered so much, he can't stand on it, the fight is over;Leg injury",

			"Nasty joint hyper-extension on %pas's [SIDE] leg, he can't fight;Leg injury",

			"%pas's [SIDE] knee cap just popped, he can't fight on;Leg injury",

			"Bad leg defense, %pas broke his [SIDE] ankle with that defense, this fight is over;Leg injury"
			));
	
	public static final ArrayList<String> armInjuries0 = new ArrayList<String>(Arrays.asList(
			"%pas Hyper-extended his [SIDE] arm;Hyper-extended arm",
			"%pas's [SIDE] arm is getting wrenched, it appears to be injured;contused left arm"
			));

	public static final ArrayList<String> legInjuries0 = new ArrayList<String>(Arrays.asList(
			"%pas hyper-extended his [SIDE] leg;hyper-extended [SIDE] leg"
			));

	
}