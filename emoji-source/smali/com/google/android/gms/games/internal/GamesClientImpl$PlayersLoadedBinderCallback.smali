.class final Lcom/google/android/gms/games/internal/GamesClientImpl$PlayersLoadedBinderCallback;
.super Lcom/google/android/gms/games/internal/AbstractGamesCallbacks;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/games/internal/GamesClientImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "PlayersLoadedBinderCallback"
.end annotation


# instance fields
.field final synthetic NE:Lcom/google/android/gms/games/internal/GamesClientImpl;

.field private final yR:Lcom/google/android/gms/common/api/a$d;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/games/Players$LoadPlayersResult;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/google/android/gms/games/internal/GamesClientImpl;Lcom/google/android/gms/common/api/a$d;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/games/Players$LoadPlayersResult;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "holder":Lcom/google/android/gms/common/api/a$d;, "Lcom/google/android/gms/common/api/a$d<Lcom/google/android/gms/games/Players$LoadPlayersResult;>;"
    iput-object p1, p0, Lcom/google/android/gms/games/internal/GamesClientImpl$PlayersLoadedBinderCallback;->NE:Lcom/google/android/gms/games/internal/GamesClientImpl;

    invoke-direct {p0}, Lcom/google/android/gms/games/internal/AbstractGamesCallbacks;-><init>()V

    const-string v0, "Holder must not be null"

    invoke-static {p2, v0}, Lcom/google/android/gms/internal/hm;->b(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/common/api/a$d;

    iput-object v0, p0, Lcom/google/android/gms/games/internal/GamesClientImpl$PlayersLoadedBinderCallback;->yR:Lcom/google/android/gms/common/api/a$d;

    return-void
.end method


# virtual methods
.method public g(Lcom/google/android/gms/common/data/DataHolder;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/games/internal/GamesClientImpl$PlayersLoadedBinderCallback;->yR:Lcom/google/android/gms/common/api/a$d;

    new-instance v1, Lcom/google/android/gms/games/internal/GamesClientImpl$LoadPlayersResultImpl;

    invoke-direct {v1, p1}, Lcom/google/android/gms/games/internal/GamesClientImpl$LoadPlayersResultImpl;-><init>(Lcom/google/android/gms/common/data/DataHolder;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/common/api/a$d;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public h(Lcom/google/android/gms/common/data/DataHolder;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/games/internal/GamesClientImpl$PlayersLoadedBinderCallback;->yR:Lcom/google/android/gms/common/api/a$d;

    new-instance v1, Lcom/google/android/gms/games/internal/GamesClientImpl$LoadPlayersResultImpl;

    invoke-direct {v1, p1}, Lcom/google/android/gms/games/internal/GamesClientImpl$LoadPlayersResultImpl;-><init>(Lcom/google/android/gms/common/data/DataHolder;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/common/api/a$d;->a(Ljava/lang/Object;)V

    return-void
.end method
