.class public Lcom/google/android/gms/internal/dj;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/ads/purchase/InAppPurchaseResult;


# instance fields
.field private final pw:Lcom/google/android/gms/internal/df;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/df;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/dj;->pw:Lcom/google/android/gms/internal/df;

    return-void
.end method


# virtual methods
.method public finishPurchase()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/dj;->pw:Lcom/google/android/gms/internal/df;

    invoke-interface {v0}, Lcom/google/android/gms/internal/df;->finishPurchase()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Could not forward finishPurchase to InAppPurchaseResult"

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/eu;->c(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/dj;->pw:Lcom/google/android/gms/internal/df;

    invoke-interface {v0}, Lcom/google/android/gms/internal/df;->getProductId()Ljava/lang/String;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v1, "Could not forward getProductId to InAppPurchaseResult"

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/eu;->c(Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPurchaseData()Landroid/content/Intent;
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/dj;->pw:Lcom/google/android/gms/internal/df;

    invoke-interface {v0}, Lcom/google/android/gms/internal/df;->getPurchaseData()Landroid/content/Intent;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v1, "Could not forward getPurchaseData to InAppPurchaseResult"

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/eu;->c(Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getResultCode()I
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/dj;->pw:Lcom/google/android/gms/internal/df;

    invoke-interface {v0}, Lcom/google/android/gms/internal/df;->getResultCode()I
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_0
    return v0

    :catch_0
    move-exception v0

    const-string v1, "Could not forward getPurchaseData to InAppPurchaseResult"

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/eu;->c(Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isVerified()Z
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/dj;->pw:Lcom/google/android/gms/internal/df;

    invoke-interface {v0}, Lcom/google/android/gms/internal/df;->isVerified()Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_0
    return v0

    :catch_0
    move-exception v0

    const-string v1, "Could not forward isVerified to InAppPurchaseResult"

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/eu;->c(Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 v0, 0x0

    goto :goto_0
.end method
