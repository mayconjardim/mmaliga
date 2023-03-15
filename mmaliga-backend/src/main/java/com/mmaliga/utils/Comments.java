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
			"Some counter punches against %pas; %loc;almost hit him as he moves away.;0;1;4;1;Punches;2;2;0;-1;0;1;1",
			"Good movement from %act;moving in to strike and moving away afterwards.;who is bobbing and weaving.;0;0;1;3;Punches;2;2;1;0;0;1;1",
			"%act fires an unorthodox punch to %pas's torso;that hits its mark.;that goes wide.;11;2;1;2;Body punch;1;1;-5;-1;-3;1;1",
			"A punch from %act;grazes %pas's left cheek.;whizzes past %pas.;4;2;1;4;Punch;1;1;0;-1;0;1;1",
			"A punch from %act;grazes %pas's right cheek.;gets blocked by %pas.;5;2;1;4;Punch;1;1;0;-1;0;1;1",
			"%act jabs at %pas;hitting his chest.;to no visible effect.;9;2;1;2;Jab;1;1;-5;-1;-2;1;1",
			"%act launches a flurry of punches;but only manages to land glancing blows.;%pas slips out of danger.;0;3;1;3;Punches;3;2;0;-1;0;1;1"));

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

			"Nice low kick from %act;Loud pop!;but %pas stops it.;15;3;1;2;Low kick;1;1;-5;-5;0;1;1"));

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
					+ "Kicks;1;1;0;1;-1;0;0;"));

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

			"Incredible high kick!;%pas is worried!;%pas deflects and sidesteps.;9;0;1;2;High kick;1;1;3;3;4;1;1"));

	public static final ArrayList<String> fancyKick1 = new ArrayList<String>(Arrays.asList(
			"%act jumps in the air and tries a flying knee!;Crushing shot! %pas's mouthpiece flies out of "
			+ "his mouth;%pas blocks with his arms and moves laterally looking for a counter;7;2;0;8;Flying "
			+ "knee;1;1;0;2;3;0;0;",
			"%act spins around and tries a spinning back kick!;%pas was not expecting something like that! It lands on "
			+ "his chin! Is this over?;%pas ducks under and hesitates for a moment...;8;2;0;3;Spinning back kick;1;1;0;2;3;0;0;",
			"%act spins around and tries a spinning back kick!;%act hits hard %pas ribs with that one! %pas's just wrenches like a little branch.;%pas blocks with his arms and leg;10;2;1;2;Spinning back kick;1;1;0;2;3;0;0;"

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

	public static final ArrayList<String> thaiPunch1 = new ArrayList<String>(Arrays.asList(
			"%act throws a wild flurry of punches while in the clinch!;%pas is being hit hard here!;%pas pushes away %act and breaks the "
					+ "clinch.;7;3;1;2;Punches;4;4;0;-2;-2;12;1",
			"%act tries to dirty boxing while holds %pas against %site;%pas is unable to "
					+ "defend himself and receives some punches in the ribs.;%pas is aware of his surroundings and scapes from the "
					+ "clinch.;10;2;1;4;Punches;3;3;0;0;0;12;1",
			"%act is grappling and launching some wild punches...;I don't know "
					+ "how %pas is eating those punches!;Not the best move against %pas who tries to take adventage of his"
					+ " opponent's mistakes.;4;4;3;7;Punches;3;2;0;0;1;12;12",
			"A dirty boxing lesson by %act who is trying"
					+ " to punish %pas's ribs with a few punches.;He scores a few hits before the pain makes %pas "
					+ "react and defend his side.;%pas brings his opponent closer and blocks %act's "
					+ "punches.;10;0;4;3;Punches;4;2;0;0;0;0;0;",
			"%act tries to strikes %pas with" + "his elbow in the clinch;nicely done %pas got hit!!! again and again, "
					+ "he have to defend himself before the ref stop this fight;%pas saw that "
					+ "coming and block it with ease;1;2;1;4;Elbows;3;3;3;1;2;0;0;",
			"both fighters are clinching, "
					+ "%act react first trying to hit %pas with a right elbow strike;big elbow!!!"
					+ " that elbow knocks %pas to the mat;%pas blocks that elbow and both man continues"
					+ "to clinch;4;2;1;4;Elbow;1;1;3;1;2;2;0;",
			"both fighters are clinching, %act react"
					+ " first trying to hit %pas with a left elbow strike;big elbow!!! that elbow"
					+ " knocks %pas to the mat;%pas blocks that elbow and both man continues"
					+ " to clinch;5;2;1;4;Elbow;1;1;3;1;2;2;0;",
			"%act was holding %pas against" + " the %holdSite, he swings his right arm over %pas head and tries"
					+ " to hit him with revese elbow ;%pas is being punish here, he got "
					+ "hit again and again the fight won't last long if this continues;%pas "
					+ "blocks that elbow and and move out of danger;4;2;1;4;Elbows;3;3;1;3;2;0;0;",
			"%act was holding %pas against the %holdSite, he swings his left arm over %pas head and tries to hit him with"
					+ " revese elbow ;%pas is being punish here, he got hit again and again the fight won't last long if this "
					+ "continues;%pas blocks that elbow and and move out of danger;5;2;1;4;Elbows;3;3;1;3;2;0;0;",
			"%act pushes %pas against the %holdSite and tries to hit him with the back of his elbow;one hits, another "
					+ "hits and the third one sends %pas to the mat;%pas blocks that easily and both man are still clinching;5;2;1;4;Elbows;3;3;1;3;2;2;0;",
			"%act pushes %pas against the %holdSite and tries to hit him with the back of his elbow;one hits, another"
					+ " hits and the third one sends %pas to the mat;%pas blocks that easily and both man are still clinching;4;2;1;4;Elbows;3;3;1;3;2;2;0;",
			"%act grapple with %pas and tries to hit him with a elbow;left elbow, right elbow and left elbow again!!! "
					+ "nice combination by %act, %pas was surely hurt there;%pas wants nothing to do with him and pushes %act away;1;2;1;4;Elbows;3;3;3;1;2;0;0;",
			"%act grapple with %pas and tries to hit him with a elbow;right elbow, left elbow and right elbow again!!! "
					+ "nice combination by %act, %pas was surely hurt there;%pas wants nothing to do with him and pushes %act away;1;2;1;4;Elbows;3;3;3;1;2;0;0;",
			"%act is clinching with %pas's back against the %holdSite, %act tries a big elbow;bang!!! what an impact!!!"
					+ " %pas drops to the mat;%pas blocks that one and force %act to come out with something better;1;2;1;4;Elbow;1;1;3;1;2;2;0;"

	));

	public static final ArrayList<String> thaiPunch2 = new ArrayList<String>(Arrays.asList(
			"%pas's corner is turning out to be his worst enemy! %act is throwing a flurry of punches!;%pas"
					+ " just can't get away!;%pas ducks under and circles out of the corner.;5;0;2;1;Punches;5;3;2;0;1;12;1",

			"%act is launching some bone breaking punches to %pas's ribs while in the clinch.;Wow."
					+ " You can see the pain in %pas's eyes.;%pas blocks.;10;0;3;4;Punches;3;3;0;2;0;12;12",

			"%act pushes off of %pas and starts launching a flurry of hooks and body shots!;%pas stumbles"
					+ " backwards but %act chases him and continues the rain of blows!;%pas holds his opponent tight while he tries to cool down the action.;3;0;3;9;Punches;6;4;0;1;1;12;12",

			"%act postures up and launches another series of punches!;A lot of them are hitting %pas hard,"
					+ " who may be wondering how to scape from this!;%pas pushes his opponent forward and blocks most of "
					+ "%act's offensive.;9;0;1;3;Punches;5;3;0;0;0;0;0;"

	));

	public static final ArrayList<String> thaiPunch3 = new ArrayList<String>(Arrays.asList(
			"Brutal punches to %pas's face while in the clinch!;%pas can't take many more shots like those!;%pas"
					+ " pushes %act with all his might as tries to keep the fight in striking range.;4;-2;1;2;Punches;5;4;3;3;3;12;1",

			"%act pushes %pas againts the %HoldSite and begin a relentless combination of punches. The crowd "
					+ "is on it's feet!;%pas cannot escape %act's clinch! %act is just brutalizing %pas with punches time and time again!;%pas "
					+ "tries to block %act punches...;6;0;3;7;Punches;4;4;2;3;4;12;12",

			"%act is absolutely terrifying with his power in the clinch, and is violently punishing %pas with uppercuts!;%pas is taking "
					+ "more than he can endure. This could end soon if %pas is unable to escape!;Nothing that %pas must fear as he blocks nicely;3;0;3;1;Punches;3;3;2;2;4;12;12",

			"%act pushes %pas against the  %holdSite and launches a few sick punches;A couple of unanswered uppercuts collide with "
					+ "%pas's chin! His legs are wobbling!;%pas blocks and pushes away his opponent creating space between them.;8;0;2;4;Uppercuts;3;2;0;0;2;0;1;",

			"Sick uppercut from the clinch by %act!;That one almost breaks %pas's chin! He is knocked down!;%pas is agile enough to avoid "
					+ "that one! Lucky you %pas! It would have finished this fight.;8;2;1;9;Uppercut;1;1;1;2;3;2;0;"

	));

	public static final ArrayList<String> dirtyBoxing1 = new ArrayList<String>(Arrays.asList(
			"%act throws a wild flurry of punches while in the clinch!;%pas is being hit hard here!;%pas pushes away %act and breaks the clinch.;7;3;1;2;Punches;4;4;0;-2;-2;12;1",

			"%act tries to dirty boxing while holds %pas against %site;%pas is unable to defend himself and receives some punches in the ribs.;%pas is aware of his surroundings and scapes from the clinch.;10;2;1;4;Punches;3;3;0;0;0;12;1",

			"%act is grappling and launching some wild punches...;I don't know how %pas is eating those punches!;Not the best move against %pas who tries to take adventage of his opponent's mistakes.;4;4;3;7;Punches;3;2;0;0;1;12;12",

			"A dirty boxing lesson by %act who is trying to punish %pas's ribs with a few punches.;He scores a few hits before the pain makes %pas react and defend his side.;%pas brings his opponent closer and blocks %act's punches.;10;0;4;3;Punches;4;2;0;0;0;0;0;",

			"%act tries to control %pas in the clinch and use his dirty boxing;%act pushes the back of %pas's head with one hand and punches his head a few times with the other, that surely hurts him; %pas pushes %act away before he could try anything;0;2;1;4;Punches;3;3;0;0;0;0;1;",

			"%act pushes %pas against the %site and tries to work his dirty boxing;%act controls %pas in the clinch and deliver a few uppercuts, nice shots %pas is hurt; %pas pushes %act away and circle away;8;2;1;4;Uppercuts;3;3;0;0;0;0;1;",

			"%act tries to holds %pas in a clinch against the %holdSite; %act pushes back %pas's head with his forehand and tries some puches to his ribs, %pas was unable to deferece himself and those puches landed hard; %pas escapes from the clinch before %act could keep him in place;10;2;1;4;Punches;3;3;0;0;0;0;1;",

			"%act is holding %pas against the %holdSite with his fingers all over %pas's face;%pas looks discomfort and tries to struggle off, %act took advantage of it and landed some big punches to the ribs;%pas looks discomfort and tries to struggle off, he slide under %act arm and move away from danger %act ;10;2;1;4;Punches;3;3;0;0;0;0;1;"

	));

	public static final ArrayList<String> dirtyBoxing2 = new ArrayList<String>(Arrays.asList(
			"%pas's corner is turning out to be his worst enemy! %act is throwing a flurry anotherof punches!;%pas"
					+ "just can't get away!;%pas ducks under and circles out of the corner.;5;0;2;1;Punches;5;3;2;0;1;12;1",

			"%act is launching some bone breaking punches to %pas's ribs while in the clinch.;Wow. You can see the pain in %pas's "
					+ "eyes.;%pas blocks.;10;0;3;4;Punches;3;3;0;2;0;12;12",

			"%act pushes off of %pas and starts launching a flurry of hooks and body shots!;%pas stumbles backwards but %act chases him and "
					+ "continues the rain of blows!;%pas holds his opponent tight while he tries to cool down the action.;3;0;3;9;Punches;6;4;0;1;1;12;12",

			"%act postures up and launches another series of punches!;A lot of them are hitting %pas hard, who may be wondering how to scape "
					+ "from this!;%pas pushes his opponent forward and blocks most of %act's offensive.;9;0;1;3;Punches;5;3;0;0;0;0;0;"));

	public static final ArrayList<String> dirtyBoxing3 = new ArrayList<String>(Arrays.asList(
			"Brutal punches to %pas's face while in the clinch!;%pas can't take many more shots like those!;%pas pushes %act with all "
					+ "his might as tries to keep the fight in striking range.;4;-2;1;2;Punches;5;4;3;3;3;12;1",

			"%act pushes %pas againts the %HoldSite and begin a relentless combination of punches. The crowd is on it's feet!;%pas cannot "
					+ "escape %act's clinch! %act is just brutalizing %pas with punches time and time again!;%pas tries to block %act punches...;6;0;3;7;Punches;4;4;2;3;4;12;12",

			"%act is absolutely terrifying with his power in the clinch, and is violently punishing %pas with uppercuts!;%pas is taking more "
					+ "than he can endure. This could end soon if %pas is unable to escape!;Nothing that %pas must fear as he blocks nicely;3;0;3;1;Punches;3;3;2;2;4;12;12",

			"%act pushes %pas against the  %holdSite and launches a few sick punches;A couple of unanswered uppercuts collide with %pas's "
					+ "chin! His legs are wobbling!;%pas blocks and pushes away his opponent creating space between them.;8;0;2;4;Uppercuts;3;2;0;0;2;0;1;",

			"Sick uppercut from the clinch by %act!;That one almost breaks %pas's chin! He is knocked down!;%pas is agile enough to avoid "
					+ "that one! Lucky you %pas! It would have finished this fight.;8;2;1;9;Uppercut;1;1;1;2;3;2;0;"));

	public static final ArrayList<String> grapplingPunch1 = new ArrayList<String>(Arrays.asList(
			"%act launches a few punches towards %pas's ribs while holds him in a double overhooks!;%pas receives a couple of blows in the "
					+ "ribs.;%pas seems unaffected... those punches doesn't carry any power!;10;1;3;3;Punches;4;2;0;0;0;0;0;",

			"%act tries to breaks %pas's resistence with a few punches while tries to push him against oner corner.;%act launches a couple of"
					+ " punches that leave marks in %pas's ribs.;%act doesn't find the right way... He have to improve his position for causing any"
					+ " real damage;10;0;3;3;Punches;2;2;0;0;0;0;0;"));

	public static final ArrayList<String> grapplingPunch2 = new ArrayList<String>(Arrays.asList(
			"%act struggles and launches a few punches to %pas's head;Those punches are hitting! %pas covers his head!;Nothing from this..."
					+ " %act seems frustrated.;0;0;3;3;Punches;3;2;0;0;0;0;0;",

			"%act tries to take %pas down... %pas stumbles backwards and %act launches a few punches...;One swing hits hard %pas's jaw!;%pas "
					+ "dodges and moves away a couple of steps...;8;1;1;9;Punch;3;1;0;0;2;0;1;",

			"%act launches a few hard punches to %pas's ribs!;%pas's ribs shows the damage! %act is working his opponent ribs!;%pas struggles"
					+ " and protects himself.;10;0;3;3;Punches;4;3;0;1;0;0;0;"));

	public static final ArrayList<String> refBreakClinch = new ArrayList<String>(Arrays.asList(
			"%ref separates the fighters and tells them to continue fighting.",

			"The referee intervenes to break the clinch. %ref sees a lack of activity in the clinch and separates the fighters."));

	public static final ArrayList<String> wrestlingTD1 = new ArrayList<String>(Arrays.asList(
			"%act is in good position and is looking to change levels for the takedown...;%act catches an ankle and %pas is tripped to the "
					+ "mat!;%pas doesn't let %act get in on his legs.;12;2;4;9;Ankle Pick;1;1;0;0;0;6;0;",

			"%act gets double underhooks and looks for the takedown...;%act blocks %pas's knee and hits a perfectly executed knee tap! Nice "
					+ "move.;%pas pummels back into position.;12;2;4;9;Knee Tap;1;1;0;0;0;6;0;",

			"%act gets himself into good position and looks to change levels for the takedown...;%act gets hold of a leg and trips %pas to"
					+ " the mat!;%pas doesn't let %act get in on his legs.;12;2;4;9;Single Leg Takedown;1;1;0;0;0;6;0;",

			"%act shoots and grab one of %pas's leg, attempting to take him down with a Single Leg; %pas lose his balance and falls to"
					+ " the mat; %pas sprawls and remain on his feet;9;3;0;0;Single Leg Takedown;0;0;0;1;1;5;0;",

			"%act shoots and grab both of %pas's leg, attempting to take him down with a Double Leg; %act lifted %pas's off his feet and"
					+ "throws him on the mat; %pas managed to pull back his leg from %act's grip and move away from him;9;3;0;0; Double Leg Takedown;0;0;0;0;0;5;0;",

			"%act tries to take %pas to the ground from the clinch...;Nicely done! %pas is with is back on the ground now.;%pas shows his "
					+ "sprawl skills and remains on his feet.;0;0;3;3;Clinch Takedown;1;1;0;0;0;5;0",

			"%act fakes a punch to %pas ribs and the tries to trip him;%pas loses balance and goes to the ground;%pas loses balance for a "
					+ "moment but he remains on his feet after a small struggle.;0;0;3;3;Clinch Takedown;1;1;0;0;0;6;0",

			"%act tries to take %pas to the ground from the clinch...;Nicely done! %pas is with his back on the ground now.;%pas shows his "
					+ "sprawl skills and remains on his feet.;0;0;3;3;Clinch Takedown;1;1;0;0;0;5;0",

			"%act fakes a punch to %pas ribs and the tries to trip him;%pas loses balance and goes to the ground;%pas loses balance for a "
					+ "moment but he remains on his feet after a small struggle.;0;0;3;3;Clinch Takedown;1;1;0;0;0;6;0",

			"%act is in good position and is looking to change levels for the takedown...;%act catches an ankle and %pas is tripped to the"
					+ " mat!;%pas doesn't let %act get in on his legs.;12;2;4;9;Ankle Pick;1;1;0;0;0;6;0;",

			"%act gets double underhooks and looks for the takedown...;%act blocks %pas's knee and hits a perfectly executed knee tap! "
					+ "Nice move.;%pas pummels back into position.;12;2;4;9;Knee Tap;1;1;0;0;0;6;0;",

			"%act gets himself into good position and looks to change levels for the takedown...;%act gets hold of a leg and trips %pas "
					+ "to the mat!;%pas doesn't let %act get in on his legs.;12;2;4;9;Single Leg Takedown;1;1;0;0;0;6;0;"

	));

	public static final ArrayList<String> judoTD1 = new ArrayList<String>(Arrays.asList(

			"%act tries a Foot Sweep takedown on %pas ;well done %pas falls hard on the mat; %act fails to take %pas down and both man are "
					+ "still clinching;12;2;4;9;Foot Sweep Takedown;1;1;0;0;0;2;0;",

			"%act grab one of %pas's arm and tries a Hip Throw;with a twist of his hip %act throw %pas to the mat like a ragdoll;%pas done well "
					+ "to maintain his balances and avoid going down;12;2;4;9;Hip Throw;1;1;0;0;0;2;0;",

			"%act grapple with %pas and tries a Inner leg Sweep;%pas falls hard on the mat with %act on top of him;%pas managed to maintain his "
					+ "balances and avoid the takedown;12;2;4;9;Inner leg Sweep;0;0;0;1;1;6;0;",

			"%act grapple with %pas and tries a Outer Leg Sweep;nice takedown %act is in side mount over %pas;%pas manage to maintain his "
					+ "balances and avoid going down;12;2;4;9;Outer Leg Sweep;0;0;0;1;1;13;0;",

			"%act and %pas are cliched up against the %site. %act steps for a throw; %pas is flat on his back. great Judo technique shown!; %pas "
					+ "stays on his feet;12;0;4;3;Judo throw clinch;0;0;-10;0;-10;13;0;",

			"%act and %pas are cliched up against the %site. %act steps for a throw; %pas is gets thrown to the mat but gets right back up; %pas"
					+ " stays on his feet;12;0;4;3;Judo throw clinch - ineffective;0;0;-10;0;-10;0;0;",

			"%act and %pas are cliched up against the %site. %act hammers %pas face and hooks %pas leg; %pas is on his back after that trip; "
					+ "%pas stays on his feet and fights off the trip;12;-5;1;3;Judo trip clinch - effective;2;2;-10;-10;-10;6;0;",

			"%act goes for a scissor takedown. thats unusual; %pas is down after that takedown and they are scrambling for position. %act gets "
					+ "the advantage; %act is on his back after that attempt;12;5;1;4;Judo - scissor takedown;0;0;-10;-10;-10;5;3;",

			"%act shoots and grab %pas's ankle trying to take him down with a Heel Trip Reversal; %act scoop up %pas's ankle with one hand and "
					+ "pushes his body with another forcing %pas to the mat; %pas sprawl and remain on his feet;9;3;0;0;Heel Trip Reversal;0;0;0;1;1;5;0;",

			"%act fakes a few punches and advance towards %pas trying to take him down with a Advancing Leg Sweep; %pas lose his balance and "
					+ "falls hard on the mat; %pas pushes %act and circle away keeping himself within striking range;9;4;0;0;Advancing Leg Sweep;0;0;0;1;1;2;1;",

			"%act tries a Foot Sweep takedown on %pas ;well done %pas falls hard on the mat;%act fails to take him down and both fighter are "
					+ "still standing;9;4;0;0; Foot Sweep Takedown;0;0;0;1;1;2;1;",

			"%act grab one of %pas's arm and tries a Hip Throw; %pas landed hard on his back; %pas done well to maintain his balances and avoid "
					+ "going down;9;5;0;0;Hip Throw;0;0;0;1;2;2;1;",

			"%act grapple with %pas and tries a Inner leg Sweep; %pas falls hard on the mat with %act on top of him; %pas managed to maintain "
					+ "his balances and move away from %act ;9;4;0;0;Inner leg Sweep;0;0;0;1;1;15;1;",

			"%act grapple with %pas and tries a Outer Leg Sweep;nice takedown %act is in side mount over %pas ; %pas manage to maintain his"
					+ " balances and avoid the takedown;9;3;0;0;Outer Leg Sweep;0;0;0;1;1;13;0;"));

	public static final ArrayList<String> breakClinch = new ArrayList<String>(Arrays.asList(
			"%act pushes away %pas trying to keep the fight at striking range;%pas stumbles backwards and %act circles to get the center"
					+ " of the %site;%pas doesn't want to break the clinch as he still is grappling with %act;0;0;3;9;Break Clinch;0;0;0;0;0;1;0",

			"%act doesn't want to clinch as he ducks under %pas embrace and tries to move away...;Nice move from %act who put distance between"
					+ " them;%pas pushes %act forward and doesn't allow him to break the clinch.;0;0;3;9;Break Clinch;0;0;0;0;0;1;0",

			"%act tries to shrug his way out of the clinch. ;%act circles out and slips free of %pas's grip. Nice job of getting out of that"
					+ "position.;%pas is determined to work from the clinch. He pummeled through and managed to retain his position.;0;0;3;9;Break Clinch;0;0;0;0;0;1;0;"));

	public static final ArrayList<String> gnp1 = new ArrayList<String>(Arrays.asList(
			"%act throws a flurry of punches at %pas...;A lot of them are hitting %pas's face;%pas is defending himself well. None of them connect.;5;2;7;8;GnP;5;4;1;0;0;0;0",

			"%act tries to launch a few punches to %pas;Little effect. A lot of them are hitting %pas's defense;%pas is able to achieve closed guard and counter %act's punches.;9;2;8;10;GnP;3;1;0;0;0;0;6",

			"%act positions himself and launches a barrage of punches.;%act is in full mount and his punches are hitting hard %pas's abdomen;%pas covers himself well;11;2;10;7;GnP;4;2;0;0;0;4;0",

			"%act positions himself and launches a barrage of punches.;%act is in full mount and his punches are hitting hard %pas's ribs;%pas covers himself well;10;2;10;7;GnP;4;2;0;0;0;4;0",

			"%act launches a few punches to %pas;Weak punches. He needs to improve his position!;%pas holds %act's arms and blocks the punches!;1;3;7;10;GnP;4;3;0;-1;-2;0;0",

			"%act launches a few punches to %pas;Weak punches. He needs to improve his position!;%pas covers himself well and then rolls on the ground. Great reversal!;1;1;7;8;GnP;4;2;0;0;0;0;9",

			"%act throws a lot of punches;some strikes get through.;with little effect. %pas is doing a great job covering himself up.;0;2;7;10;GnP;3;1;-1;-1;-2;0;0",

			"Pitty-pat punches from %act;They're bothering %pas even though they aren't hurting him.;%pas doesn't flinch.;0;2;7;10;GnP;3;2;-1;-1;-2;0;0",

			"Body shots by %act;Solid blows to %pas's abdomen.;%pas covers up.;11;1;8;7;GnP;2;2;-2;0;-2;0;0"));

	public static final ArrayList<String> gnp2 = new ArrayList<String>(Arrays.asList(
			"%act tries to  open %pas's guard...;Great bombs from the top by %act. %pas is unable to cover himself "
					+ "now!;%pas breaks the lock and covers himself from %act's punches;1;0;10;7;GnP;6;4;2;0;1;0;0",

			"%act gets a good position on the ground. ..;and what an incredible flurry! He's just wailing away at %pas!"
					+ " The referee is saying he's going to stop it if %pas doesn't defend himself!;%pas holds %act arms and counters his opponent punches.;6;0;7;10;GnP;5;5;2;0;2;0;0",

			"%act tries to open up %pas's defense faking a few punches.;He is aggressively and repeatedly punching %pas "
					+ "in the side of the head;%pas wraps his arms around %act's arms and counters the punches.;1;0;10;7;GnP;4;4;2;0;1;0;0",

			"%act hovers above %pas;Good punches to %pas's body.;%pas stops him from throwing strikes.;9;1;7;13;GnP;3;3;0;0;-1;0;0",

			"%act fakes some punches;then lands a big punch to %pas's face!;%pas ties him up.;0;1;8;7;GnP;1;1;0;0;2;0;0",

			"%act throws a few hammer fists to the face of %pas;Solid shots!;Blocked by %pas.;0;1;7;13;GnP;4;4;0;0;2;0;0",

			"%act aggressively and repeatedly punches %pas.;He needs to do something soon or the referee will stop the "
					+ "fight!;Good job by %pas blocking and slipping the blows.;0;0;10;10;GnP;5;4;2;0;1;0;0",

			"Good looking punches from %act on the ground;They could take their toll on %pas.;deflected by %pas.;0;1;10;7;GnP;3;3;1;0;0;0;0"));

	public static final ArrayList<String> inRearMountMoves = new ArrayList<String>(Arrays.asList(
			"%pas has given his back to %act who is trying to get one hook in!;%act has one hook in!;%pas struggles in the ground trying to break"
					+ " %act's control;0;-2;10;10;Ground move;1;1;0;0;0;7;0",

			"%act tries to get a hook in!;Things get worse for %pas! %act has one hook in and keeps working!;%pas rolls on the ground and manages "
					+ "to get a half guard!;0;-2;10;10;Ground move;1;1;0;0;0;7;15"

	));

	public static final ArrayList<String> inRearMountOneHookMoves = new ArrayList<String>(Arrays.asList(
			"%act has one hook in and is trying to get the second one! If he succeed things are goint to get very bad for %pas.;Nicely done!"
					+ "%act now has two hooks in! The end may be near!;%pas uses his leg as leverage and manages to keep himself safe for "
					+ "now.;0;-2;0;0;Ground move;1;1;0;0;0;7;0"

	));

	public static final ArrayList<String> inRearMountTwoHooksMoves = new ArrayList<String>(Arrays.asList(
			"%act is in rear mount with two hooks in! He is working on a desperate %pas, who tries to defend himself and escape from that "
					+ "position.;%act moves looking to sink a rear naked choke and finish this.;%pas is holding his opponent arms defending well.;0;0;10;10;"
					+ "Ground move;0;0;0;0;0;0;0;",
			"%act tenatively looks for a way to finish his opponent! This is a nightmare for %pas!;%act has one of his arm over %pas's "
					+ "shoulder and is ready for a RNC!;%pas rolls on the ground and he is looking at the ceiling while %act's on his back but with "
					+ "only one hook in!;0;0;10;10;Ground move;0;0;0;0;0;0;17;",
			"%act tenatively looks for a way to finish his opponent! This is a nightmare for %pas!;%pas adopts the turtle defense and "
					+ "%act is ready to make his way to the victory with a round of punches!;%pas rolls on the ground and he finishes being fully"
					+ " mounted by %act;0;0;10;10;Ground move;0;0;0;0;0;0;4;"

	));

	public static final ArrayList<String> defInRearMountMoves = new ArrayList<String>(Arrays.asList(
			"%act has %pas controlling his back while on the ground. He tries to roll and find an escape...;Showing some ground skills he "
					+ "transitions to a side mount.;%pas is unable to move under %act control.;0;2;10;8;Ground move;1;1;0;0;0;14;0",
			"%act has %pas controlling his back while on the ground. He tries to roll and find an escape...;Showing some ground skills %act "
					+ "manages to escape from that position and climb to his feet along %pas;%pas is unable to move under %act control.;0;2;8;6;Ground "
					+ "move;1;1;0;0;0;1;10"

	));

	public static final ArrayList<String> defInRearMountOneHookMoves = new ArrayList<String>(Arrays.asList(
			"%act is trying to escape from the rear mount.;%act holds %pas's arm over his shoulder and then rolls on the ground. "
					+ "Incredible move to get a half mount!;%pas tries to use some of his tricky moves but %pas's is smart enough to counter "
					+ "him.;0;3;6;8;Ground move;1;1;0;0;0;13;0",
			"%act has to use some of his skills to escape safely from this position...;%act uses his ground skills to free one of his legs while "
					+ "working on the ground.;%act is unable to find a way to scape from this.;0;2;8;6;Ground move;1;1;0;0;0;17;0"

	));

	public static final ArrayList<String> defInRearMountTwoHooksMoves = new ArrayList<String>(Arrays.asList(
			"%act is trying to escape from the rear mount.;%act holds %pas's arm over his shoulder and then rolls on the ground. Incredible move"
					+ " to get a half mount!;%pas tries to use some of his tricky moves but %pas's is smart enough to counter him.;0;3;6;8;Ground"
					+ " move;1;1;0;0;0;13;0",
			"%act has to use some of his skills to escape safely from this position...;%act uses his ground skills to free one of his legs while "
					+ "working on the ground.;%act is unable to find a way to escape from this.;0;2;8;6;Ground move;1;1;0;0;0;17;0"

	));

	public static final ArrayList<String> inFullMountMoves = new ArrayList<String>(Arrays.asList(
			"%act tries to better his position on the ground...;%act is in a great position to begin a nice round of pounding!;%pas tries to "
					+ "roll on the ground...;0;2;7;10;Ground move;0;0;0;0;0;0;10",
			"%pas tries to roll to his side and get to half guard...;%act rolls %pas to his stomach and takes his back!;%pas creates enough space to"
					+ " control %act's leg.;0;0;0;0;Ground move;0;0;0;0;0;7;15;",
			"%pas tries to roll to his side and trap %act in his guard...;%act rolls him over and takes his back!;%pas gets his hips out and gets to"
					+ "full guard.;0;0;0;0;Ground move;0;0;0;0;0;7;6;",
			"%act tries to keep hs position while looking to maybe begin a pounding session...;%act controls the situation despite %pas efforts for "
					+ "escaping from the full mount.;%pas struggles and frees his leg!;0;0;0;0;Ground move;0;0;0;0;0;0;15;",
			"%act tries to keep hs position while looking to maybe begin a pounding session...;%act controls the situation despite %pas efforts for"
					+ " escaping from the full mount.;%pas struggles and pushes his opponent maybe a bit anxiously;0;0;10;13;Ground move;0;0;0;0;0;0;0;",
			"%pas tries to escape from the full mount...;%act is not caught off guard and moves to side mount to keep his superior position.;%pas "
					+ "struggles and pushes his opponent maybe a bit anxiously;0;0;10;13;Ground move;0;0;0;0;0;13;0;"

	));

	public static final ArrayList<String> defInFullMountMoves = new ArrayList<String>(Arrays.asList(
			"%act tries to roll on the ground...;He makes a reversal!;%pas knows how to keep his advantage on the ground.;0;0;8;10;Ground "
					+ "move;0;0;0;0;0;6;8",
			"%act tries to move on the ground and escape from the full mount!;He successfully moves to half guard!;%pas doesn't want to lose his"
					+ "adventageous position and he struggles to mantain the full mount.;10;0;8;5;Ground move;0;0;0;0;0;16;0;",
			"%act tries to roll to his side and trap %pas in his guard...;%act moves to half guard.;%pas keeps good control and remains in full "
					+ "mount.;0;0;0;0;Ground move;0;0;0;0;0;16;0;",
			"%act tries to roll to his side and trap %pas in his guard...;%act gets his hip out and moves to full guard.;%pas keeps good control"
					+ " and remains in full mount.;0;0;0;0;Ground move;0;0;0;0;0;9;0;",
			"%act tries to roll to his side and trap %pas in his guard...;%act gets his hip out and moves to full guard.;%pas keeps good control"
					+ " and remains in full mount.;0;0;0;0;Ground move;0;0;0;0;0;8;0;",
			"%act is using some of his ground skills to escape from this...;He pushes %pas's knee away and tries to roll! Nice move to get half "
					+ "guard!;%pas pushes %act down and prevents his attempts to escape;0;0;8;5;Ground Move;0;0;0;0;0;15;0;"

	));

	public static final ArrayList<String> inSideMountMoves = new ArrayList<String>(Arrays.asList(
			"%act tries to move to full mount!;Nice move. He is in full mount now.;%pas won't allow him to take this position easily."
					+ ";0;0;10;13;Ground move;0;0;0;0;0;4;13",
			"%act looks to pass to mount...;%act slides his knee across and achieves the mount position! Tough spot for %pas.;%pas creates space and"
					+ " scrambles back to his feet.;0;0;0;0;Side Mount Pass;0;0;0;0;0;4;1;",
			"%act looks to mount %pas...;%act slides his knee across and gets to mount.;%pas sees an opening and locks his opponent in half"
					+ " guard.;0;0;0;0;Ground move;0;0;0;0;0;4;15;",
			"%act looks to mount %pas...;%act slides his knee across and gets to mount.;%pas takes advantage of his opponent's over commitment and "
					+ "traps him in full guard.;0;0;0;0;Ground move;0;0;0;0;0;4;5;",
			"%act looks to mount %pas...;%act slides his knee across and gets to mount.;%pas takes advantage of his opponent's over commitment and"
					+ " traps him in full guard.;0;0;0;0;Ground move;0;0;0;0;0;4;6;"

	));

	public static final ArrayList<String> defInSideMountMoves = new ArrayList<String>(Arrays.asList(
			"%act tries to show some ground skills;%act put %pas in half guard.;%pas uses his strength to keep %pas at a "
					+ "disadvantage;0;2;10;8;Ground move;0;0;0;0;0;16;14",
			"%act attempts to trap %pas in his guard.;%act manages to switch to half guard.;%pas keeps control and remains in side"
					+ " mount.;0;0;0;0;Ground move;0;0;0;0;0;16;0;",
			"%act attempts to trap %pas in his guard.;%act manages to switch to full guard.;%pas keeps control and remains in side"
					+ " mount.;0;0;0;0;Ground move;0;0;0;0;0;9;0;",
			"%act attempts to trap %pas in his guard.;%act manages to switch to full guard.;%pas keeps control and remains in side"
					+ " mount.;0;0;0;0;Ground move;0;0;0;0;0;10;0;"

	));

	public static final ArrayList<String> inHalfGuardMoves = new ArrayList<String>(Arrays.asList(
			"%act pushes %pas's  leg and tries to move to full mount.;Nice move by %act who is in full mount! %pas is in trouble "
					+ "now!;%pas rolls and he's now on half guard over %act. Nice reversal.;0;0;0;0;Ground move;0;0;0;0;0;4;16",
			"%act pushes %pas's  leg and tries to move to full mount.;Nice move by %act who is in full mount! %pas is in trouble "
					+ "now!;%pas wraps his legs while he holds %act's head... Tight guard!;0;2;8;7;Ground move;0;0;0;0;0;4;15",
			"%act tries to free his leg...;He moves to side mount!;%pas doesn't allow any movement here! He's cooling the fight on "
					+ "the ground.;0;2;10;7;Ground move;0;0;0;0;0;13;0",
			"%act sits over his knees and pushes away %pas's leg!;%act is able to put away his leg and then jumps to side mount.;%pas "
					+ "closes his legs around %act's leg. %act is not able to move away now!;0;0;13;15;Ground move;0;0;0;0;0;13;0;",
			"%act launches a few fake punches and tries to escape!;%pas is covering himself! %act tries to force the situation and %pas"
					+ " clumsily gives his back!;%act is countered by %pas.;0;0;7;14;Ground move;0;0;0;0;0;7;0;",
			"%act launches a few fake punches and tries to escape!;%pas is not able to stop %pas ground skills and %act moves to side"
					+ " mount!;%pas rolls over himself and stands up while %act rolls on his back.;0;0;0;0;Ground move;0;0;0;0;0;13;3;",
			"%act tries to pass %pas's guard...;%act manages to get his leg free and moves to side mount.;%act passes momentarily but "
					+ "%pas regains half guard.;0;0;0;0;Ground move;0;0;0;0;0;13;0;",
			"%act tries to pass %pas's guard...;%act manages to get his leg free and moves to side mount.;%act passes momentarily but "
					+ "%pas sees and opening and traps him in full guard.;0;0;0;0;Ground move;0;0;0;0;0;13;5;",
			"%act tries to pass %pas's guard...;%act manages to get his leg free and moves to side mount.;%act passes momentarily but "
					+ "%pas sees and opening and traps him in full guard.;0;0;0;0;Ground move;0;0;0;0;0;13;6;",
			"%act tries to pass %pas's guard...;%act manages to get his leg free and moves to side mount.;%pas's guard is too good and he"
					+ "fails to pass.;0;0;0;0;Ground move;0;0;0;0;0;13;0;",
			"%act tries to get a side mount...;He frees his leg and is now controlling %pas from the side mount!;%pas wraps his leg around"
					+ " %act leg and prevents him from moving.;0;0;10;7;Ground move;0;0;0;0;0;13;0;",
			"%act tries to get a side mount...;He frees his leg and is now controlling %pas from the side mount!;%pas wraps his leg around"
					+ " %act leg and prevents him from moving.;0;0;13;10;Ground move;0;0;0;0;0;13;0;",
			"%act tries to free his leg;%act uses some of his skill by jumping out of %pas's guard. He moves quickly to side mount!;%pas moves"
					+ " fast and both fighters exchange some weak punches while climbing to their feet.;0;0;0;0;Ground move;0;0;0;0;0;13;1;",
			"%act tries to free his leg;%act uses some of his skill by jumping out of %pas's guard. He moves quickly to side mount!;%pas moves"
					+ "fast and both fighters exchange some weak punches while climbing to their feet.;0;0;0;0;Ground move;0;0;0;0;0;13;1;",
			"%act tries to free his leg...;%act uses some of his skill by jumping out of %pas's guard. He moves quickly to full mount!;%pas rolls"
					+ " on the ground and moves to side mount! Awesome maneuver!;0;0;0;0;Ground move;0;0;0;0;0;13;14;"

	));

	public static final ArrayList<String> defInHalfGuardMoves = new ArrayList<String>(Arrays.asList(
			"%act tries to close the guard.;%act put %pas in closed guard.;Nothing from this effort.;0;2;8;10;Ground move;0;0;0;0;0;10;0",
			"%act attempts to move to full guard;%act manages to switch to full guard.;%pas keeps good control and remains in "
					+ "half guard.;0;0;0;0;Ground move;0;0;0;0;0;9;0;",
			"%act attempts to move to full guard;%act manages to switch to full guard.;%pas keeps good control and remains in half "
					+ "guard.;0;0;0;0;Ground move;0;0;0;0;0;10;0;"

	));

	public static final ArrayList<String> inOpenGuardMoves = new ArrayList<String>(Arrays.asList(
			"%act tries to move to full mount;%act succeeds;%act's ground game is not enough to provide him any "
					+ "advantage;0;2;10;8;Ground move;0;0;0;0;0;4;5",
			"%act moves on the ground;%act moves to side mount;%act cannot take advantage in the ground;0;2;10;8;Ground "
					+ "move;0;0;0;0;0;13;5",
			"%act tries to jump to side mount.;%pas closed his guard around %act.;%pas jumps and show some wrestling skills as"
					+ " he positions himself for continuing the fight in side control.;0;0;0;0;Ground move;0;0;0;0;0;13;10;",
			"%act pushes %pas against the %HoldSite and then tries to improve his position.;%act jumps and tries to free his leg! "
					+ "%pas doesn't allow this but %act is able to get half guard here.;%pas struggles not allowing %act improve his position.;0;0;10;13;Ground move;0;0;0;0;0;15;0;",
			"%act tries to pass to half guard...;%pas can't prevent his opponent from passing. %act looks to work from half guard.;%pas's"
					+ " guard is too good and he fails to pass.;0;0;0;0;Ground move;0;0;0;0;0;15;0;",
			"%act tries to pass to half guard...;%pas can't prevent his opponent from passing. %act looks to work from half guard.;%pas's "
					+ "closes his guard to prevent the pass.;0;0;0;0;Ground move;0;0;0;0;0;15;6;",
			"%act moves on the ground..;He gets half guard.;...he makes no progress.;0;0;10;8;Ground move;0;0;0;0;0;15;5",
			"%act moves on the ground...;..and gets to half guard.;He remains in open guard.;0;0;10;8;Ground move;0;0;0;0;0;15;5",
			"%act tries to improve position.;He frees a leg.;%pas adjusts and closes his guard.;0;0;10;8;Ground move;0;0;0;0;0;15;6"

	));

	public static final ArrayList<String> defInOpenGuardMoves = new ArrayList<String>(Arrays.asList(
			"%a2 tries to close his guard around %d2;He succeeds!;He is not able to do it;0;2;0;0;Ground move;0;0;0;0;0;10;9"

	));

	public static final ArrayList<String> inClosedGuardMoves = new ArrayList<String>(Arrays.asList(
			"%act tries to better his position on the ground...;%act breaks the closed guard of %pas and moves to half guard;%pas "
					+ "holds %act's head against his chin in the closed guard.;0;2;7;10;Ground move;0;0;0;0;0;13;6",
			"%act struggles on the ground and tries to break %pas's guard...;%act is in %pas open guard now;%pas doesn't want to free his"
					+ " opponent and %act continues in closed guard;0;2;10;7;Ground move;0;0;0;0;0;5;6",
			"%act tries to escape from the closed guard;%act succeeds and he's now in open guard... he takes a second to breathe;%act any "
					+ "adventage in the ground.;0;2;7;10;Ground move;0;0;0;0;0;5;6",
			"%act tries to improve his position on the ground as he sits on his knees and tries to break the closed guard.;%act fakes a few "
					+ "punches and then slips one leg to get the half mount.;%pas leans and gets %act's arms as he brings him to the ground again.;11;0;10;7;Ground move;0;0;0;0;0;15;0;",
			"%act tries to escape from closed guard...;%act struggles to liberate his leg and jumps to half guard!;%pas waits for the moment and "
					+ "tries to roll! Too late for %act! He is reversed and nor %pas is on half guard!;0;0;0;0;Ground move;0;0;0;0;0;15;16;",
			"%act use some of his wrestling skills to escape from the closed guard!;After a few tentative moves, he jumps to side mount! The crowd "
					+ "in %venue is cheering him!;%pas holds %act and prevents him from moving to a better position!;0;0;7;10;Ground move;0;0;0;0;0;13;0;",
			"%act looks to posture up and open %pas's guard... ;%act forces %pas to open his guard.;%pas has a solid guard and keeps his ankles "
					+ "locked.;0;0;0;0;Ground move;0;0;0;0;0;5;0;",
			"%act is looking to pass %pas's guard...;%act gets his hips free and moves to half guard.;%pas has a solid guard and keeps his ankles "
					+ "locked.;0;0;0;0;Ground move;0;0;0;0;0;15;0;",
			"%act tries to pass %pas's guard...;%act manages to get his leg free and moves to half guard.;%act passes momentarily but %pas regains "
					+ "full guard.;0;0;0;0;Ground move;0;0;0;0;0;15;0;"

	));

	public static final ArrayList<String> defInClosedGuardMoves = new ArrayList<String>(Arrays.asList(
			"%pas is in closed guard... %act tries to roll on the ground!;Nice reversal! He is now in full mount over %pas!;%pas uses "
					+ "his leg to keep his position on the ground;0;1;8;10;Ground Move;0;0;0;0;0;4;10"

	));

	public static final ArrayList<String> inButterflyGuardMoves = new ArrayList<String>(Arrays.asList(
			"%act looks to pass the guard of %pas...;%act pushes down on %pas's leg and passes to half guard.;%pas blocks %act's hand and "
					+ "retains his position.;0;0;0;0;Butterfly Pass;0;0;0;0;0;15;0;",

			"%act looks to pass the guard of %pas...;%act removes the hook and steps over into %pas's half guard.;%act leaves himself open and "
					+ "is swept onto his back!;0;0;0;0;Butterfly Pass;0;0;0;0;0;15;9;"

	));

	public static final ArrayList<String> defInButterflyGuardMoves = new ArrayList<String>(Arrays.asList(
			"%pas is in %act's butterfly guard...;%act extends his legs and sweeps %pas to his back! "
					+ "He gains side mount.;%pas kicks his leg back and resets.;0;1;8;10;Ground Move;0;0;0;0;0;13;0;",

			"%pas is in %act's butterfly guard...;%act extends his legs and sweeps %pas to his back! He gains "
					+ "side mount.;%pas shifts his hips and frees himself of the hooks.;0;1;8;10;Ground Move;0;0;0;0;0;13;10;"

	));

	public static final ArrayList<String> slamOut = new ArrayList<String>(Arrays.asList(
			"%act tries to break the lock slamming %pas against the mat!;After a couple of slams, %pas loses the lock! What an impressive power "
			+ "demonstration!;%pas doesn't allow %act to escape. He is tightening the %movename;10;0;0;0;Slam;1;1;0;1;1;2;0;",
			"%act lifts his opponent from the ground displaying great power! And down he goes!;%pas loses the lock after that incredible blow "
			+ "against the mat! What a slam!;%pas doesn't break the lock and %act is running out of time!;9;0;0;0;Slam;1;1;0;1;1;5;0;"
	));

	public static final ArrayList<String> lockingSubmission = new ArrayList<String>(Arrays.asList(

			"%%act is locking that %movename...",
			"Crippling lock!",
			"You can see the pain reflected in %%pas's eyes...",
			"That %movename from %%act appears to be unbreakable",
			"%pas struggles to free himself",
			"Punishing hold!",
			"That %movename looks tight... "
	));

	public static final ArrayList<String> subRefStoppage = new ArrayList<String>(Arrays.asList(
			"%ref breaks %act's lock! This is over! %pas didn't want to tap but the ref decided he wouldn't be able to escape from it!",
			"%act secures the lock while %pas refuses to tap... %ref jumps in and breaks the lock!"
	));

	public static final ArrayList<String> closedGuardSub1 = new ArrayList<String>(Arrays.asList(
			"%act moves to high guard and tries to close an armbar!;That was incredible! %pas is tapping out before knowing what happened"
			+ ".;%pas breaks the lock, rolls on the ground and stands up quickly.;13;1;10;8;armbar;1;1;0;0;0;10;3",
			"%act tries an armbar from the bottom!;That was incredible! %pas is tapping out before knowing what happened.;%pas breaks the "
			+ "lock and moves himself to side control.;13;1;10;11;armbar;1;1;0;0;0;10;14",
			"%act throws up a triangle attempt!;He locks it in! %pas is in trouble! He struggles for a few seconds before tapping. That's "
			+ "all she wrote, folks.;%pas postures up and breaks the triangle.;0;1;10;8;Triangle;1;1;0;0;0;0;0;",
			"%act slides his legs high and tries to apply a triangle!;%pas didn't realize how much danger he was in and is caught! He knows"
			+ " now and quickly taps!;%pas cuts to the side and manages to pass to side mount!;0;1;10;5;Triangle;1;1;0;0;0;0;14;",
			"%act sits up and gets an arm around %pas's neck!;He wraps up a tight guillotine! %pas tries to roll but cannot relieve the "
			+ "pressure on his neck. %pas is forced to tap to that guillotine! The fight is over, just like that!;%pas pushes %act back to the ground.;0;2;8;10;Guillotine;1;1;0;0;0;0;0;",
			"%act reaches under and rolls for a kneebar!;%act gets his hips extended and %pas is grimacing in pain. %pas can take the"
			+ " pain no longer and taps!;%pas blocks the attempt and uses the opportunity to seize half guard.;17;2;10;8;Kneebar;1;1;0;0;0;0;16;",
			"%act reaches under and rolls for a kneebar!;%act gets his hips extended and %pas is grimacing in pain. %pas can take the "
			+ "pain no longer and taps!;%pas blocks the attempt and uses the opportunity to seize half guard.;18;2;10;8;Kneebar;1;1;0;0;0;0;16;",
			"%act isolates an arm in a kimura attempt! ;%act locks his hands together and rotates %pas's right arm! Great move! %pas has no "
			+ "choice but to tap.;%pas blocks the hold and uses the opportunity to pass %act's guard.;14;1;10;8;Kimura;1;1;0;0;0;0;16;",
			"%act isolates an arm in a kimura attempt! ;%act locks his hands together and rotates %pas's left arm! Great move! %pas has no "
			+ "choice but to tap.;%pas blocks the hold and uses the opportunity to pass %act's guard.;13;1;10;8;Kimura;1;1;0;0;0;0;16;",
			"%act throws his legs up in a triangle attempt!;He locks it in! He locks in an armbar for good measure that forces %pas to tap out"
			+ " rather than have his arm broken!;%pas realizes the danger and stands up to avoid the attack.;14;1;11;14;Triangle Armbar;1;1;0;0;0;0;3;",
			"%act throws his legs up in a triangle attempt!;He locks it in! He locks in an armbar for good measure that forces %pas to tap out "
			+ "rather than have his arm broken!;%pas realizes the danger and stands up to avoid the attack.;13;1;11;14;Triangle Armbar;1;1;0;0;0;0;3;",
			"%act attempts a triangle from bottom! %pas slips out. %act quickly turns his hips over and switches to the armbar! He's throwing "
			+ "everything at him.;%pas tries to roll out but it's too deep and he taps! Awesome technique!;%pas slips out and backs away to avoid danger.;14;2;11;14;Triangle to Armbar;2;1;0;0;0;0;3;",
			"%act attempts a triangle from bottom! %pas slips out. %act quickly turns his hips over and switches to the armbar! He's throwing "
			+ "everything at him.;%pas tries to roll out but it's too deep and he taps! Awesome technique!;%pas slips out and backs away to avoid danger.;13;2;11;14;Triangle to Armbar;2;1;0;0;0;0;3;",
			"%act gets an arm and tries to apply an armbar. %pas spins out, but %act was ready for that and quickly switches to a triangle "
			+ "choke!;The triangle looks deep! Incredible BJJ skills! %pas holds out as long as he can before he is forced to tap.;%pas is too good and managed to back out of danger.;0;1;11;14;Armbar to Triangle;2;1;0;0;0;0;3;",
			"%act overhooks an arm and starts cranking! Interesting meneuver.;%act begins rotating %pas's elbow deeper and deeper. %pas screams "
			+ "in pain and taps until the referee separates the fighters! The fight is over, just like that!;%pas pulls his arm out of danger.;14;3;8;10;Shoulder Lock;1;1;0;0;0;0;0;",
			"%act overhooks an arm and starts cranking! Interesting meneuver.;%act begins rotating %pas's elbow deeper and deeper. %pas screams "
			+ "in pain and taps until the referee separates the fighters! The fight is over, just like that!;%pas pulls his arm out of danger.;13;3;8;10;Shoulder Lock;1;1;0;0;0;0;0;",
			"%act switches to high guard just before trying to sink a triangle!;%pas taps with his remaining strength before going to sleep. "
			+ "Beatiful move by %act.;%pas struggles and his head turns red from the choke, but he manages to slip his head of the lock!;0;0;10;15;Triangle Choke;0;0;0;-1;0;0;0;",
			"%act switches to high guard just before trying to sink a triangle!;%pas taps with his remaining strength before going to sleep. "
			+ "Beatiful move by %act.;%pas struggles and his head turns red from the choke, but he manages to slip his head of the lock!;0;0;8;10;Triangle Choke;0;0;0;-1;0;0;0;"
	));

	public static final ArrayList<String> standUpSub1 = new ArrayList<String>(Arrays.asList(
			"Big mistake from %pas! %act tries to finish him off with a RNC!;%pas struggles helplessly but that choke by %act seems "
			+ "to be unbreakable! He is out!;%act is unable to lock that and %pas breaks the lock;0;0;1;3;Rear Nacked Choke;1;1;0;0;1;0;0",
			"%act tries to finish this with a rear naked chocke!;%act closes the choke! %pas's face is turning crimson red! He taps!;%pas "
			+ "ducks under and pushes away his opponent.;0;0;1;3;rear naked chocke;1;1;0;0;0;0;1",
			"%act locks up a guillotine with an arm in...;He brings %pas down to the mat and it looks deep! %pas quickly taps before passing"
			+ " out!;%pas brings %act down to the ground and pulls his head out.;0;3;10;8;Arm-in Guillotine;1;1;-1;-2;0;0;10;",
			"%act locks up a guillotine and tries to pull guard...;It's deep! %pas cannot escape and taps before going out!;%pas slips his"
			+ " head out and ends up in %act's guard.;0;3;15;10;Standing Guillotine;1;1;-2;0;0;0;10;",
			"%act gets control of %pas's neck and attempts a guillotine!;%pas tries to wriggle free but it's deep. He can't slip out and has "
			+ "to tap!;%pas shakes him off and staves off danger.;0;3;1;10;Standing Guillotine;1;1;-2;0;0;0;0;"
			));
	
	public static final ArrayList<String> openGuardSub1 = new ArrayList<String>(Arrays.asList(
			"%act tries to finish with a leg lock!;This is over! %pas can't stand the pain and taps!;%pas is able to break the "
			+ "lock.;19;0;10;7;leglock;1;1;0;0;0;5;0",
			"%act tries to finish with a leg lock!;This is over! %pas can't stand the pain and taps!;%pas is able to break the "
			+ "lock.;20;0;10;7;leglock;1;1;0;0;0;5;0",
			"%act is in open guard over %pas... he fakes a move and then tries a kneebar!;%pas screams in pain and taps! %ref "
			+ "forces %act to break the lock.;%pas rolls on the ground trying to get free and after a few kicks of his own he "
			+ "escapes.;17;2;7;15;Kneebar;1;1;0;0;0;0;3;",
			"%act is in open guard over %pas... he fakes a move and then tries a kneebar!;%pas screams in pain and taps! %ref"
			+ " forces %act to break the lock.;%pas rolls on the ground trying to get free and after a few kicks of his own he "
			+ "escapes.;18;2;7;15;Kneebar;1;1;0;0;0;0;3;"

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
					+ " takedown by %act.;%pas was ready and shrugs off the takedown attempt.;12;2;2;3;Sweep Single;1;1;0;0;0;6;0;"));

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
			Arrays.asList("%pas has a small cut in his %loc;Small cut %loc",
					"There is a small laceration on %pas's %loc;Small cut %loc"));

	public static final ArrayList<String> faceInjuries0 = new ArrayList<String>(
			Arrays.asList("%pas's %loc is beginning to swell;%loc swelling",
					"%pas's %loc is bruised after the punishement he's received!;%loc bruising"));

	public static final ArrayList<String> faceInjuries1 = new ArrayList<String>(Arrays.asList(
			"%pas can't see anything with that swollen left eye.;Swollen Eye",

			"%pas can't see anything with that swollen right eye.;Swollen Eye",

			"%pas is out! He has a broken orbital bone!;Broken orbital bone",

			"%pas is out! He has a broken cheekbone!;Broken cheeckbone",

			"%pas can't continue fighting. %ref doesn't allow him to continue fighting with his swollen right eye!;Swollen eye",

			"%pas can't continue fighting. %ref doesn't allow him to continue fighting with his swollen left eye!;Swollen eye"));

	public static final ArrayList<String> bodyInjuries0 = new ArrayList<String>(
			Arrays.asList("Crushing shot to %pas's body! He's holding his side;Contused side",
					"Hard blow to %pas's mid-section, he seems hurt;Contused side",
					"%pas ribs are getting hammered, they look bad!;Hammered ribs"));

	public static final ArrayList<String> bodyInjuries1 = new ArrayList<String>(
			Arrays.asList("%pas has a broken rib. He can't continue fighting.;Broken Rib",
					"%pas may have a broken rib. It's painful to see him losing this way.;Broken Ribs",
					"%pas's holding his side, he appears to be in terrible pain, he's broken a rib ;Broken Ribs"));

	public static final ArrayList<String> armInjuries1 = new ArrayList<String>(Arrays.asList(
			"%pas [SIDE] arm has been Hyper-extended so much it appears its dislocated, the fight is over;Arm injury",

			"Thats a joint Hyper-extension you don't want, %pas has broken his [SIDE] arm,this fight is over;Broken arm",

			"He hit him so hard %pas has broken his [SIDE] hand;Broken hand "
					+ "It appears %pas broke his [SIDE] wrist with that block;Broken wrist"));

	public static final ArrayList<String> legInjuries1 = new ArrayList<String>(Arrays.asList(
			"%pas's [SIDE] leg has been hammered so much, he can't stand on it, the fight is over;Leg injury",

			"Nasty joint hyper-extension on %pas's [SIDE] leg, he can't fight;Leg injury",

			"%pas's [SIDE] knee cap just popped, he can't fight on;Leg injury",

			"Bad leg defense, %pas broke his [SIDE] ankle with that defense, this fight is over;Leg injury"));

	public static final ArrayList<String> gnp3 = new ArrayList<String>(Arrays.asList(
			"%act wants to finish his opponent on the ground;%act drills %pas's face with a huge right hand! What an"
					+ " impact!;%act can't find an opening in his opponent's guard!;6;-1;10;7;GnP;1;1;2;2;2;0;0",

			"%act moves to better his position on the ground...;%act viciously slams hammer blows to %pas's face!;%act"
					+ " wraps his arms around his opponents' and tries to switch positions;1;0;10;7;GnP;3;3;1;2;3;0;14",

			"%act leans back...;He clobbers %pas's face with a huge punch! Ouch!;%pas eyes him warily.;0;0;10;7;GnP;1;1;1;1;2;0;0",

			"%act is looking to end this fight with strikes;He starts to pound away at %pas, who is barely "
					+ "covering up!;%pas anticipates his moves and avoids danger.;0;-1;10;7;GnP;5;4;1;1;3;0;15",

			"%act fires a barrage of punches at %pas's head!;This is bad! %act is just pounding on %pas's "
					+ "head like he's a training dummy! The referee looks on anxiously!;The punches go wide.;0;0;10;7;GnP;5;4;1;1;2;0;0",

			"%act throws down elbows...;He's tearing up %pas's face with those brutal elbows! %pas needs to do something! The referee is"
					+ " threatening to stop it!;%pas is not making himself an easy target.;0;0;10;8;GnP;5;5;2;1;1;0;0"));

	public static final ArrayList<String> armInjuries0 = new ArrayList<String>(
			Arrays.asList("%pas Hyper-extended his [SIDE] arm;Hyper-extended arm",
					"%pas's [SIDE] arm is getting wrenched, it appears to be injured;contused left arm"));

	public static final ArrayList<String> legInjuries0 = new ArrayList<String>(
			Arrays.asList("%pas hyper-extended his [SIDE] leg;hyper-extended [SIDE] leg"));

	
	public static final ArrayList<String> sideMountSub1 = new ArrayList<String>(Arrays.asList(
			"%act tries a kimura;Nicely done! %pas must tap!;%pas breaks the lock.;13;0;10;7;kimura;1;1;0;0;0;13;13",
			"%act goes for an americana!;He locks it in! %pas is forced to tap!;%pas breaks free.;13;0;10;7;Americana;1;1;0;0;0;0;0;",
			"%act goes for an americana!;He locks it in! %pas is forced to tap!;%pas breaks free.;14;0;10;7;Americana;1;1;0;0;0;0;0;",
			"%act isolates %pas's arm and neck looking for an arm triangle;%act locks it in and circles towards %pas's head."
			+ " It's deep and %pas is forced to tap out!;%pas is able to relieve the pressure on his neck and slip out of the hold.;0;0;10;7;Arm Triangle;1;1;0;0;0;0;0;",
			"%act hooks %pas's left leg and sits back for a kneebar!;%act extends his hips and it's deep. %pas taps! Smart move,"
			+ " %pas could have been seriously injured by that punishing lock.;%pas manages to kick %act away and scrambles on top!;17;2;8;10;Kneebar;1;1;0;0;0;0;9;",
			"%act hooks %pas's right leg and sits back for a kneebar!;%act extends his hips and it's deep. %pas taps! Smart move, "
			+ "%pas could have been seriously injured by that punishing lock.;%pas manages to kick %act away and scrambles on top!;18;2;8;10;Kneebar;1;1;0;0;0;0;9;",
			"%act shifts to north-south position and tries to finish with a lock!;%pas is out! %ref breaks the lock and %pas lies "
			+ "flat on the mat! Awesome move by %act.;%pas pushes %act forward against his back and breaks the lock!;0;0;0;0;North South Choke;0;0;0;0;0;0;10;",
			"%act isolates %pas's right arm looking for an armbar... ;%pas tries to hold onto his own arm but %act breaks his grip "
			+ "and extends his arm for the tap!;%pas manages to sit up and pull his arm out of danger! %act lost his dominant position.;14;1;15;8;armbar;1;1;-1;1;0;0;9;",
			"%act isolates %pas's left arm looking for an armbar... ;%pas tries to hold onto his own arm but %act breaks his grip "
			+ "and extends his arm for the tap!;%pas manages to sit up and pull his arm out of danger! %act lost his dominant position.;13;1;15;8;armbar;1;1;-1;1;0;0;9;",
			"%pas tries to turn away and scramble out. %act takes his back and locks up a rear naked choke!;%pas is trying to find "
			+ "an escape but it's too deep! He's forced to tap out before going to sleep!;He can't lock it up. %pas spins out and gets back to his feet.;0;1;9;3;rear naked choke;1;1;-2;0;0;0;1;",
			"%pas tries to turn in and scramble out. %act timed him perfectly and locks up a guillotine!;%pas can't find a way out! "
			+ "His face is turning purple and he taps before going to sleep!;%pas slips his head out and manages to gain top control.;0;1;15;8;guillotine;1;1;-2;0;0;0;9;"
			));
	
	public static final ArrayList<String> fullMountSub1 = new ArrayList<String>(Arrays.asList(
			"%act tries to finish the fight with an armbar from the top;The pain forces %pas to tap! This is over!;%pas is smart "
			+ "enough to avoid the submission attempt;13;0;10;8;armbar;1;1;0;0;0;0;0",
			"%act tries to finish the fight with an armbar from the top;The pain forces %pas to tap! This is over!;%pas is smart "
			+ "enough to avoid the submission attempt;14;0;10;8;armbar;1;1;0;0;0;0;0",
			"%act catch %pas's left arm and tries a kimura;%pas's arm is bent at an awful angle! %pas's taps again and again;%pas"
			+ " holds his own arm and struggles until he gets free;13;0;10;8;kimura;1;1;0;0;0;0;0",
			"%act catch %pas's right arm and tries a kimura;%pas's arm is bent at an awful angle! %pas's taps again and "
			+ "again;%pas holds his own arm and struggles until he gets free;14;0;10;8;kimura;1;1;0;0;0;0;0",
			"%act isolates %pas's arm and neck looking for an arm triangle;%act locks it in and circles towards %pas's head."
			+ " It's deep and %pas is forced to tap out!;%pas is able to relieve the pressure on his neck and slip out of the"
			+ " hold.;0;0;10;8;Arm Triangle;1;1;0;0;0;0;0;",
			"%act sits high on %pas's chest and pulls his leg underneath %pas's head. There's the triangle attempt!;%pas tries "
			+ "to roll out, but %act is way ahead of him and already has the triangle locked in. It's tight and %pas taps out!;%pas tries to roll out. He's too quick for %act and manages to slip out! That was a risky move by %act and it cost him top position.;0;0;10;8;Triangle from Mount;1;1;0;0;0;0;10;",
			"%act fakes a few punches and after a brief struggle he catches %pas's arm and tries an armbar!;%act launches a couple"
			+ " of strikes with his heels over %pas's face and then launches himself backwards with all his might! %pas taps with a pained grin.;%pas hold his own hand and breaks %act's lock. He rolls over himself and launches over %act.;14;0;0;0;Armbar;0;0;0;0;1;0;14;",
			"%act fakes a few punches and after a brief struggle he catches %pas's arm and tries an armbar!;%act launches a couple "
			+ "of strikes with his hooks over %pas's face and then launches himself backwards with all his might! %pas taps with a pained grin.;%pas holds his own hand and with pure strength he breaks %pas's lock. He rolls over himself and launches over %act.;13;0;0;0;Armbar;0;0;0;0;1;0;14;",
			"%act goes for an armbar!;%pas taps out after a text book armbar!;%pas breaks the lock and pushes away %act, who rolls "
			+ "over his back and gets to standing position.;13;0;0;0;Armbar;0;0;0;0;0;0;2;",
			"%act goes for an armbar!;%pas taps out after a text book armbar!;%pas breaks the lock and pushes away %act, who rolls "
			+ "over his back and gets to standing position.;14;0;0;0;Armbar;0;0;0;0;0;0;2;",
			"%act takes a deep breath as he passes his arm over %pas shoulder and pushes his [SIDE] arm againts the mat!;%act shows a"
			+ " pained grimace and he repeatedly taps out after a perfect americana!;%pas breaks that americana attempt!;14;1;13;10;Americana;0;0;0;0;0;0;0;",
			"%act takes a deep breath as he passes his arm over %pas shoulder and pushes his [SIDE] arm againts the mat!;%act shows a"
			+ " pained grimace and he repeatedly taps out after a perfect americana!;%pas breaks that americana attempt!;13;1;13;10;Americana;0;0;0;0;0;0;0;",
			"%act suddenly holds %pas's arm and tries an armbar!;%pas almost dind't see what was happening before tap!;%pas can break "
			+ "the lock and now he is in a closed guard over %act!;13;0;0;0;Armbar;1;1;0;0;0;0;10;",
			"%act suddenly holds %pas's arm and tries an armbar!;%pas almost dind't see what was happening before tap!;%pas can break "
			+ "the lock and now he is in a closed guard over %act!;14;0;0;0;Armbar;1;1;0;0;0;0;10;",
			"%act throws the leg over and rolls it over into an armbar!;That's more than %pas can stand! His arm is outstretched and he "
			+ "taps before getting an injury.;%pas breaks the lock showing some skills...;14;0;10;15;Armbar;1;1;0;1;0;0;0;",
			"%act throws the leg over and rolls it over into an armbar!;That's more than %pas can stand! His arm is outstretched and he"
			+ " taps before getting an injury.;%pas breaks the lock showing some skills...;13;0;10;15;Armbar;1;1;0;1;0;0;0;"
			));
	
	public static final ArrayList<String> rearSub1 = new ArrayList<String>(Arrays.asList(
			"%act tries to end this with a RNC!;%pas is turning blue as the iron lock is closed around his neck. %pas is blacking out "
			+ "and he taps before going to sleep!;%pas manages to roll on the ground and break the lock;-1;-3;10;10;RNC;1;1;0;0;2;0;16",
			"%act isolates an arm looking for an armbar from the back...;%act throws his leg over and %pas is in serious trouble! %act "
			+ "extends his hips and %pas is forced to tapout to the crafty armbar!;%pas locks his hands and forces his weight on top of %act unil he can pull his arm free! %act lost his dominant position.;14;2;10;8;Armbar;1;1;0;0;0;0;10;",
			"%act isolates an arm looking for an armbar from the back...;%act throws his leg over and %pas is in serious trouble! %act"
			+ " extends his hips and %pas is forced to tapout to the crafty armbar!;%pas locks his hands and forces his weight on top of %act unil he can pull his arm free! %act lost his dominant position.;13;2;10;8;Armbar;1;1;0;0;0;0;10;",
			"%act slides his arm under %pas's chin and locks in a rear naked choke!;%pas can't defend any longer and has to tap!;%pas "
			+ "pushes up and slides %act's arm over his chin.;0;1;10;0;Rear Naked Choke;1;1;-1;-1;0;0;0;",
			"%act slides his arm under %pas's chin and locks the rear naked choke!;%pas's face turns completely red before he taps out!;%pas"
			+ " pulls down on %act's hand and staves off danger;0;1;10;0;Rear Naked Choke;1;1;-1;-1;0;0;0;",
			"%act tries to get his arm under %pas's chin but can't do it. He locks his arms over %pas's neck and tries to finish him with a "
			+ "neck crank! ;%pas's neck is twisted at a nasty angle. He tries to hold on but the pain is too much for him. He taps out!;%pas easily defends the attempt.;0;1;10;0;Neck Crank;1;1;-1;-1;0;0;0;",
			"%act throws his leg over %pas's arm leaving him with only one arm to defend himself from %act's rear naked choke attempt! ;%pas"
			+ " cannot defend with only one arm and taps to the choke!;%pas frees his arm and defends the choke. He manages to turn into %act"
			+ " and ends up on top!;0;1;10;0;Rear Naked Choke;1;1;-3;-3;0;0;10;"
			));
	
	public static final ArrayList<String> standUp = new ArrayList<String>(Arrays.asList(
			"%act tries to stand up!;he is now on his feet;%pas doesn't allow him!",
			"%act doesn't want to continue the fight in this position and tries to get back on his feet;He moves "
			+ "fast and now he is standing;He can't do it because of %pas's moves."
			));
	
	public static final ArrayList<String> lnp = new ArrayList<String>(Arrays.asList(
			"%act shows not much action on the ground... He seems happy to let the time pass.;%act is cooling the fight on the"
			+ " ground;%pas doesn't like the idea of just stalling on the ground;0;0;10;8;LnP;0;0;0;0;0;0;0",
			"%act takes advantage of the situation to take a breather.;%act breaths deeply while on the ground;%act struggles "
			+ "to not give his opponent a chance to recover;0;0;10;7;LnP;0;0;0;0;0;0;0",
			"%act seems content to just hold this position.;%act is taking this opportunity to rest.;%pas is getting frustrated "
			+ "here.;0;0;10;7;LnP;0;0;0;0;0;0;0;"
			));
	
	public static final ArrayList<String> fancyPunch1 = new ArrayList<String>(Arrays.asList(
			"%act moves forward and tries a Superman punch!;Bang! That crushes %pas's face and maybe his hopes of winning this "
			+ "fight too!;%pas dodges just moving aside. %act has created a big hole that %pas could use now!;5;2;1;4;Superman punch;1;1;1;2;4;0;0",
			"%act suddenly spins around...;and he connects with a spinning back fist just on %pas's chin!;%pas was aware of "
			+ "that move and blocks it with confidence.;8;3;9;1;Spinning back fist;1;1;0;0;5;0;0",
			"%act put some serious power behind that superman punch!;That's just incredible! That punch hits %pas's face like "
			+ "a wrecking ball!;That punch barely misses as %pas steps backwards!;6;2;2;1;Superman punch;1;1;0;1;5;0;0",
			"%act spins around suddenly...;...and his backfist connects flush with %pas's chin!;%pas ducks under and that just "
			+ "passes over his head.;8;3;1;2;Spinning back fist;1;1;0;1;4;0;0"
			));
	
	public static final ArrayList<String> vazio3237 = new ArrayList<String>(Arrays.asList(

			));
	
	public static final ArrayList<String> vazio232 = new ArrayList<String>(Arrays.asList(

			));
}