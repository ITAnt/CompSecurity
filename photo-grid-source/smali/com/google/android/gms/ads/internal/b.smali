.class final Lcom/google/android/gms/ads/internal/b;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/pb;

.field final synthetic b:Lcom/google/android/gms/ads/internal/zzc;


# direct methods
.method constructor <init>(Lcom/google/android/gms/ads/internal/zzc;Lcom/google/android/gms/internal/pb;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/ads/internal/b;->b:Lcom/google/android/gms/ads/internal/zzc;

    iput-object p2, p0, Lcom/google/android/gms/ads/internal/b;->a:Lcom/google/android/gms/internal/pb;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    iget-object v0, p0, Lcom/google/android/gms/ads/internal/b;->b:Lcom/google/android/gms/ads/internal/zzc;

    new-instance v1, Lcom/google/android/gms/internal/pa;

    iget-object v2, p0, Lcom/google/android/gms/ads/internal/b;->a:Lcom/google/android/gms/internal/pb;

    invoke-direct {v1, v2}, Lcom/google/android/gms/internal/pa;-><init>(Lcom/google/android/gms/internal/pb;)V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/internal/zzc;->zzb(Lcom/google/android/gms/internal/pa;)V

    return-void
.end method
