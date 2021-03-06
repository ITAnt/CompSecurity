.class public final Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/games/leaderboard/SubmitScoreResult$Result;
    }
.end annotation


# static fields
.field private static final nI:[Ljava/lang/String;


# instance fields
.field private iC:I

.field private mD:Ljava/lang/String;

.field private nJ:Ljava/lang/String;

.field private nK:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/google/android/gms/games/leaderboard/SubmitScoreResult$Result;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/16 v0, 0x8

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "leaderboardId"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "playerId"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "timeSpan"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "hasResult"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "rawScore"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "formattedScore"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "newBest"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "scoreTag"

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->nI:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "statusCode"    # I
    .param p2, "leaderboardId"    # Ljava/lang/String;
    .param p3, "playerId"    # Ljava/lang/String;

    .prologue
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;-><init>(ILjava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V

    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 0
    .param p1, "statusCode"    # I
    .param p2, "leaderboardId"    # Ljava/lang/String;
    .param p3, "playerId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/google/android/gms/games/leaderboard/SubmitScoreResult$Result;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p4, "results":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Integer;Lcom/google/android/gms/games/leaderboard/SubmitScoreResult$Result;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->iC:I

    iput-object p2, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->nJ:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->mD:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->nK:Ljava/util/HashMap;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/common/data/d;)V
    .locals 9
    .param p1, "dataHolder"    # Lcom/google/android/gms/common/data/d;

    .prologue
    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Lcom/google/android/gms/common/data/d;->getStatusCode()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->iC:I

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->nK:Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/google/android/gms/common/data/d;->getCount()I

    move-result v7

    const/4 v0, 0x3

    if-ne v7, v0, :cond_2

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/google/android/gms/internal/dm;->m(Z)V

    move v6, v1

    :goto_1
    if-ge v6, v7, :cond_3

    invoke-virtual {p1, v6}, Lcom/google/android/gms/common/data/d;->q(I)I

    move-result v8

    if-nez v6, :cond_0

    const-string v0, "leaderboardId"

    invoke-virtual {p1, v0, v6, v8}, Lcom/google/android/gms/common/data/d;->c(Ljava/lang/String;II)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->nJ:Ljava/lang/String;

    const-string v0, "playerId"

    invoke-virtual {p1, v0, v6, v8}, Lcom/google/android/gms/common/data/d;->c(Ljava/lang/String;II)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->mD:Ljava/lang/String;

    :cond_0
    const-string v0, "hasResult"

    invoke-virtual {p1, v0, v6, v8}, Lcom/google/android/gms/common/data/d;->d(Ljava/lang/String;II)Z

    move-result v0

    if-eqz v0, :cond_1

    new-instance v0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult$Result;

    const-string v1, "rawScore"

    invoke-virtual {p1, v1, v6, v8}, Lcom/google/android/gms/common/data/d;->a(Ljava/lang/String;II)J

    move-result-wide v1

    const-string v3, "formattedScore"

    invoke-virtual {p1, v3, v6, v8}, Lcom/google/android/gms/common/data/d;->c(Ljava/lang/String;II)Ljava/lang/String;

    move-result-object v3

    const-string v4, "scoreTag"

    invoke-virtual {p1, v4, v6, v8}, Lcom/google/android/gms/common/data/d;->c(Ljava/lang/String;II)Ljava/lang/String;

    move-result-object v4

    const-string v5, "newBest"

    invoke-virtual {p1, v5, v6, v8}, Lcom/google/android/gms/common/data/d;->d(Ljava/lang/String;II)Z

    move-result v5

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult$Result;-><init>(JLjava/lang/String;Ljava/lang/String;Z)V

    const-string v1, "timeSpan"

    invoke-virtual {p1, v1, v6, v8}, Lcom/google/android/gms/common/data/d;->b(Ljava/lang/String;II)I

    move-result v1

    invoke-direct {p0, v0, v1}, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->a(Lcom/google/android/gms/games/leaderboard/SubmitScoreResult$Result;I)V

    :cond_1
    add-int/lit8 v1, v6, 0x1

    move v6, v1

    goto :goto_1

    :cond_2
    move v0, v1

    goto :goto_0

    :cond_3
    return-void
.end method

.method private a(Lcom/google/android/gms/games/leaderboard/SubmitScoreResult$Result;I)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->nK:Ljava/util/HashMap;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public getLeaderboardId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->nJ:Ljava/lang/String;

    return-object v0
.end method

.method public getPlayerId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->mD:Ljava/lang/String;

    return-object v0
.end method

.method public getScoreResult(I)Lcom/google/android/gms/games/leaderboard/SubmitScoreResult$Result;
    .locals 2
    .param p1, "timeSpan"    # I

    .prologue
    iget-object v0, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->nK:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult$Result;

    return-object v0
.end method

.method public getStatusCode()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->iC:I

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    invoke-static {p0}, Lcom/google/android/gms/internal/dl;->d(Ljava/lang/Object;)Lcom/google/android/gms/internal/dl$a;

    move-result-object v0

    const-string v1, "PlayerId"

    iget-object v2, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->mD:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/dl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/dl$a;

    move-result-object v0

    const-string v1, "StatusCode"

    iget v2, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->iC:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/dl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/dl$a;

    move-result-object v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    const/4 v0, 0x3

    if-ge v1, v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult;->nK:Ljava/util/HashMap;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult$Result;

    const-string v3, "TimesSpan"

    invoke-static {v1}, Lcom/google/android/gms/internal/ev;->R(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/dl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/dl$a;

    const-string v3, "Result"

    if-nez v0, :cond_0

    const-string v0, "null"

    :goto_1
    invoke-virtual {v2, v3, v0}, Lcom/google/android/gms/internal/dl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/dl$a;

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_0
    invoke-virtual {v0}, Lcom/google/android/gms/games/leaderboard/SubmitScoreResult$Result;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    :cond_1
    invoke-virtual {v2}, Lcom/google/android/gms/internal/dl$a;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
