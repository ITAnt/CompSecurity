.class public final enum Lcom/facebook/orca/a/g;
.super Ljava/lang/Enum;
.source "MessengerGroupNameUpsellInitializer.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/facebook/orca/a/g;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/facebook/orca/a/g;

.field public static final enum INITIALIZED:Lcom/facebook/orca/a/g;

.field public static final enum INITIALIZING:Lcom/facebook/orca/a/g;

.field public static final enum UNINITIALIZED:Lcom/facebook/orca/a/g;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 31
    new-instance v0, Lcom/facebook/orca/a/g;

    const-string v1, "UNINITIALIZED"

    invoke-direct {v0, v1, v2}, Lcom/facebook/orca/a/g;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/orca/a/g;->UNINITIALIZED:Lcom/facebook/orca/a/g;

    new-instance v0, Lcom/facebook/orca/a/g;

    const-string v1, "INITIALIZING"

    invoke-direct {v0, v1, v3}, Lcom/facebook/orca/a/g;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/orca/a/g;->INITIALIZING:Lcom/facebook/orca/a/g;

    new-instance v0, Lcom/facebook/orca/a/g;

    const-string v1, "INITIALIZED"

    invoke-direct {v0, v1, v4}, Lcom/facebook/orca/a/g;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/facebook/orca/a/g;->INITIALIZED:Lcom/facebook/orca/a/g;

    .line 30
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/facebook/orca/a/g;

    sget-object v1, Lcom/facebook/orca/a/g;->UNINITIALIZED:Lcom/facebook/orca/a/g;

    aput-object v1, v0, v2

    sget-object v1, Lcom/facebook/orca/a/g;->INITIALIZING:Lcom/facebook/orca/a/g;

    aput-object v1, v0, v3

    sget-object v1, Lcom/facebook/orca/a/g;->INITIALIZED:Lcom/facebook/orca/a/g;

    aput-object v1, v0, v4

    sput-object v0, Lcom/facebook/orca/a/g;->$VALUES:[Lcom/facebook/orca/a/g;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/facebook/orca/a/g;
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/facebook/orca/a/g;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/facebook/orca/a/g;

    return-object v0
.end method

.method public static values()[Lcom/facebook/orca/a/g;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/facebook/orca/a/g;->$VALUES:[Lcom/facebook/orca/a/g;

    invoke-virtual {v0}, [Lcom/facebook/orca/a/g;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/facebook/orca/a/g;

    return-object v0
.end method
