.class public final Lcom/google/android/gms/internal/jq;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# static fields
.field public static final CREATOR:Lcom/google/android/gms/internal/jr;

.field static final Wm:J


# instance fields
.field private final Vl:J

.field private final Wn:Lcom/google/android/gms/internal/jm;

.field private final mPriority:I

.field final xM:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    new-instance v0, Lcom/google/android/gms/internal/jr;

    invoke-direct {v0}, Lcom/google/android/gms/internal/jr;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/jq;->CREATOR:Lcom/google/android/gms/internal/jr;

    sget-object v0, Ljava/util/concurrent/TimeUnit;->HOURS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v2, 0x1

    invoke-virtual {v0, v2, v3}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v0

    sput-wide v0, Lcom/google/android/gms/internal/jq;->Wm:J

    return-void
.end method

.method public constructor <init>(ILcom/google/android/gms/internal/jm;JI)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/jq;->xM:I

    iput-object p2, p0, Lcom/google/android/gms/internal/jq;->Wn:Lcom/google/android/gms/internal/jm;

    iput-wide p3, p0, Lcom/google/android/gms/internal/jq;->Vl:J

    iput p5, p0, Lcom/google/android/gms/internal/jq;->mPriority:I

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/jq;->CREATOR:Lcom/google/android/gms/internal/jr;

    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 6
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    if-ne p0, p1, :cond_1

    .end local p1    # "object":Ljava/lang/Object;
    :cond_0
    :goto_0
    return v0

    .restart local p1    # "object":Ljava/lang/Object;
    :cond_1
    instance-of v2, p1, Lcom/google/android/gms/internal/jq;

    if-nez v2, :cond_2

    move v0, v1

    goto :goto_0

    :cond_2
    check-cast p1, Lcom/google/android/gms/internal/jq;

    .end local p1    # "object":Ljava/lang/Object;
    iget-object v2, p0, Lcom/google/android/gms/internal/jq;->Wn:Lcom/google/android/gms/internal/jm;

    iget-object v3, p1, Lcom/google/android/gms/internal/jq;->Wn:Lcom/google/android/gms/internal/jm;

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hk;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    iget-wide v2, p0, Lcom/google/android/gms/internal/jq;->Vl:J

    iget-wide v4, p1, Lcom/google/android/gms/internal/jq;->Vl:J

    cmp-long v2, v2, v4

    if-nez v2, :cond_3

    iget v2, p0, Lcom/google/android/gms/internal/jq;->mPriority:I

    iget v3, p1, Lcom/google/android/gms/internal/jq;->mPriority:I

    if-eq v2, v3, :cond_0

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method public getInterval()J
    .locals 2

    iget-wide v0, p0, Lcom/google/android/gms/internal/jq;->Vl:J

    return-wide v0
.end method

.method public getPriority()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/jq;->mPriority:I

    return v0
.end method

.method public hashCode()I
    .locals 4

    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/google/android/gms/internal/jq;->Wn:Lcom/google/android/gms/internal/jm;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-wide v2, p0, Lcom/google/android/gms/internal/jq;->Vl:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget v2, p0, Lcom/google/android/gms/internal/jq;->mPriority:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/android/gms/internal/hk;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public jf()Lcom/google/android/gms/internal/jm;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/jq;->Wn:Lcom/google/android/gms/internal/jm;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    invoke-static {p0}, Lcom/google/android/gms/internal/hk;->e(Ljava/lang/Object;)Lcom/google/android/gms/internal/hk$a;

    move-result-object v0

    const-string v1, "filter"

    iget-object v2, p0, Lcom/google/android/gms/internal/jq;->Wn:Lcom/google/android/gms/internal/jm;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hk$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hk$a;

    move-result-object v0

    const-string v1, "interval"

    iget-wide v2, p0, Lcom/google/android/gms/internal/jq;->Vl:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hk$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hk$a;

    move-result-object v0

    const-string v1, "priority"

    iget v2, p0, Lcom/google/android/gms/internal/jq;->mPriority:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hk$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hk$a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/hk$a;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "parcel"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    sget-object v0, Lcom/google/android/gms/internal/jq;->CREATOR:Lcom/google/android/gms/internal/jr;

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/jr;->a(Lcom/google/android/gms/internal/jq;Landroid/os/Parcel;I)V

    return-void
.end method
