package de.chaos.mc.server.mlgrushhub.utils.statsLibary;

import com.google.common.math.Stats;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import de.chaos.mc.server.mlgrushhub.utils.daos.StatsDAO;
import de.chaos.mc.serverapi.utils.daos.DAOManager;

import java.sql.SQLException;
import java.util.UUID;

public class StatsRepository implements StatsInterface {
    public JdbcPooledConnectionSource connectionSource;
    public DAOManager<StatsDAO, UUID> daoManager;

    public StatsRepository(JdbcPooledConnectionSource jdbcPooledConnectionSource) {
        this.connectionSource = jdbcPooledConnectionSource;
        this.daoManager = new DAOManager<StatsDAO, UUID>(StatsDAO.class, connectionSource);
    }

    @Override
    public void addKills(UUID uuid, long amount) {
        StatsDAO statsDAO = null;
        try {
            if (!(getKills(uuid) == 0)) {
                statsDAO.setKills(getKills(uuid) + amount);
            } else {
                statsDAO = StatsDAO.builder()
                        .uuid(uuid)
                        .kills(amount)
                        .deaths(0)
                        .brokenBeds(0)
                        .wins(0)
                        .build();
                daoManager.getDAO().createOrUpdate(statsDAO);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void addDeaths(UUID uuid, long amount) {
        StatsDAO statsDAO = null;
        try {
            if (!(getDeaths(uuid) == 0)) {
                statsDAO.setDeaths(getDeaths(uuid) + amount);
            } else {
                statsDAO = StatsDAO.builder()
                        .uuid(uuid)
                        .kills(0)
                        .deaths(amount)
                        .brokenBeds(0)
                        .wins(0)
                        .build();
                daoManager.getDAO().createOrUpdate(statsDAO);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void addBrokenBeads(UUID uuid, long amount) {
        StatsDAO statsDAO = null;
        try {
            if (!(getDeaths(uuid) == 0)) {
                statsDAO.setBrokenBeds(getDeaths(uuid) + amount);
            } else {
                statsDAO = StatsDAO.builder()
                        .uuid(uuid)
                        .kills(0)
                        .deaths(0)
                        .brokenBeds(amount)
                        .wins(0)
                        .build();
                daoManager.getDAO().createOrUpdate(statsDAO);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public long getKills(UUID uuid) {
        StatsDAO statsDAO = null;
        try {
            statsDAO = daoManager.getDAO().queryForId(uuid);
            if (statsDAO != null) {
                return statsDAO.getKills();
            } else {
                return 0;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return 0;
        }
    }

    @Override
    public long getDeaths(UUID uuid) {
        StatsDAO statsDAO = null;
        try {
            statsDAO = daoManager.getDAO().queryForId(uuid);
            if (statsDAO != null) {
                return statsDAO.getDeaths();
            } else {
                return 0;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return 0;
        }
    }

    @Override
    public long getBrokenBed(UUID uuid) {
        StatsDAO statsDAO = null;
        try {
            statsDAO = daoManager.getDAO().queryForId(uuid);
            if (statsDAO != null) {
                return statsDAO.getBrokenBeds();
            } else {
                return 0;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return 0;
        }
    }

    @Override
    public void addWin(UUID uuid, long amount) {
        StatsDAO statsDAO = null;
        try {
            if (!(getDeaths(uuid) == 0)) {
                statsDAO.setDeaths(getKills(uuid) + amount);
            } else {
                statsDAO = StatsDAO.builder()
                        .uuid(uuid)
                        .kills(0)
                        .deaths(0)
                        .brokenBeds(0)
                        .wins(amount)
                        .build();
                daoManager.getDAO().createOrUpdate(statsDAO);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public long getWin(UUID uuid) {
        StatsDAO statsDAO = null;
        try {
            statsDAO = daoManager.getDAO().queryForId(uuid);
            if (statsDAO != null) {
                return statsDAO.getWins();
            } else {
                return 0;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return 0;
        }
    }

    @Override
    public void checkIfFirstJoin(UUID uuid) {
        StatsDAO statsDAO = null;
        try {
            if (daoManager.getDAO().queryForId(uuid) == null) {
                statsDAO = StatsDAO.builder()
                        .uuid(uuid)
                        .kills(0)
                        .deaths(0)
                        .brokenBeds(0)
                        .wins(0)
                        .build();
                daoManager.getDAO().createOrUpdate(statsDAO);
            }
        } catch (SQLException exception) {


        }
    }
}
