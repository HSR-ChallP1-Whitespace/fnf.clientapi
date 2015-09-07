namespace java com.zuehlke.carrera.ressource
namespace py com.zuehlke.carrera.ressource

typedef bool boolean
typedef i32 int
typedef i64 long
typedef string String



struct PilotLifeSignThrift {
	1: String teamId;
    2: String accessCode;
    3: String optionalUrl;
    4: long timestamp;
}

struct PowerControlThrift {
	1: String teamId;
    2: String accessCode;
    3: int p;
    4: long timeStamp;
    5: int t;
}


 enum RaceTypeThrift {

    TRAINING,
    COMPETITION
}

struct RaceStartMessageThrift {

    1: String trackId;
    2: RaceTypeThrift type;
    3: String teamId;
    4: String description;
    5: boolean recordData;
    6: long timestamp;

}


struct RaceStopMessageThrift {
	1: String trackId;
    2: String teamId;
    3: long timeStamp;
    4: RaceTypeThrift raceType;
}

struct VelocityMessageThrift {

	1: String racetrackId;
    2: long timeStamp;
    3: double velocity;
    4: String sourceId;
    5: int t;

}

struct PenaltyMessageThrift {

	1: double actualSpeed;
    2: double speedLimit;
    3: int penalty_ms;
    4: String barrier;
    5: String raceTrack;

}

struct SensorEventThrift {

    1: String raceTrackId;
    2: long timeStamp;
    3: list<int> a;
    4: list<int> g;
    5: list<int> m;
    6: int t;
}

struct RoundPassedMessageThrift {

	 1: long timeStamp;
     2: String raceTrackId;

}


