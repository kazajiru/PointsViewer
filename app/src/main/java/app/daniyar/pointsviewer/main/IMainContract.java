package app.daniyar.pointsviewer.main;

public interface IMainContract {
    interface IMainViewer {
        void init();

        void showLoader();

        void dismissLoader();

        void onPointsLoaded();

        void onPointsLoadFailed(String errorMessage);
    }

    interface IMainPresenter {
        void init();

        void submit(Integer count);
    }
}
